package com.switchfully.eurder.aapreperation;

import com.switchfully.eurder.domain.repositories.ItemRepository;
import com.switchfully.eurder.domain.repositories.UserRepository;
import com.switchfully.eurder.exception.exceptions.ValidateItemInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public OrderService(OrderMapper orderMapper, OrderRepository orderRepository, UserRepository userRepository, ItemRepository itemRepository) {
        this.orderMapper = orderMapper;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
    }

    public AllOrdersDTO getAllOrdersFromOneCustomerById(String customerId) {
        userRepository.getCustomerById(customerId); //checks if user exists!
        addDescription(orderMapper.toOrderDTOList(orderRepository.getAllOrdersFromOneCustomerById(customerId))); //returns List<OrderDTO>
        return null;
    }

    //add the description of the item
    private void addDescription(List<OrderDTO> orders) {
        for(OrderDTO order: orders){
            for(AllItemGroupDTO item: order.getItemGroupList()){
                item.setDescription(itemRepository.getItemById(item.getItemId()).getDescription());
            }
        }
    }

    public TotalPriceDTO orderItems(CreateOrderDTO createOrderDTO) {
        validateOrderItemInput(createOrderDTO); //control about the input!!  ok
        userRepository.getCustomerById(createOrderDTO.getCustomerId()); //checks if user exists! ok
        validateItemId(createOrderDTO);  //checks if items exists
        Order newOrder = orderMapper.createOrderDTOToDomain(createOrderDTO); // change from DTO to Domain
        setShippingDateItemGroupOrder(newOrder); //some logic to calculate the shippingDate and add to object!!
        calculateTotalPriceOfOrder(newOrder); //calculate cost and add to object
        orderRepository.addNewOrder(newOrder); //save it in the database
        return orderMapper.toDTO(newOrder);
    }

    private void validateOrderItemInput(CreateOrderDTO createOrderDTO) {
        boolean controlFactor = false;
        String message = "";

        if (createOrderDTO.getCustomerId() == null || createOrderDTO.getCustomerId().isBlank()) {
            message += "Please add a customer ID   ";
            controlFactor = true;
        }

        // wont be possible I think
        if (createOrderDTO.getItemGroupList().isEmpty()) {
            message += "Please add items to your order   ";
            controlFactor = true;
        }

        List<CreateItemGroupDTO> newList = createOrderDTO.getItemGroupList().stream()
                .filter(f -> f.getItemId().isBlank())
                .toList();


        if (!newList.isEmpty()) {
            message += "Please add an item id   ";
            controlFactor = true;
        }

        List<CreateItemGroupDTO> newList2 = createOrderDTO.getItemGroupList().stream()
                .filter(f -> f.getAmount() <= 0)
                .toList();

        if (!newList2.isEmpty()) {
            message += "Please add an amount higher then 0   ";
            controlFactor = true;
        }

        if (controlFactor) {
            throw new ValidateItemInput(message);
        }
    }

    private void validateItemId(CreateOrderDTO createOrderDTO) {
        List<String> itemIds = createOrderDTO.getItemGroupList().stream()
                .map(CreateItemGroupDTO::getItemId)
                .toList();

        for (String item : itemIds) {
            itemRepository.getItemById(item);
        }
    }

    //some logic to calculate the shippingDate!!
    private void setShippingDateItemGroupOrder(Order order) {
        for (ItemGroup item : order.getItemGroupList()) {
            //refactoring needed
            //if items in Stock is higher or same as order then the shipping date is the next day
            if (itemRepository.getItemById(item.getItemId()).getAmountInStock() >= item.getAmount()) {
                item.setShippingDate(LocalDate.now().plusDays(1));//shipping date +1
                itemRepository.changeAmountInItemRepository(item.getItemId(), item.getAmount());
            } else {
                item.setShippingDate(LocalDate.now().plusDays(7));//shipping date +7
                itemRepository.getItemById(item.getItemId()).setAmountInStock(itemRepository.getItemById(item.getItemId()).getAmountInStock() - item.getAmount());
            }
        }
    }

    private double calculateTotalPriceOfOrder(Order order){
        double price = 0.0;
        for(ItemGroup item: order.getItemGroupList()){
            price += itemRepository.getItemById(item.getItemId()).getPrice().getAmount() * item.getAmount();
        }
        order.setCost(price);
        return price;
    }


}




