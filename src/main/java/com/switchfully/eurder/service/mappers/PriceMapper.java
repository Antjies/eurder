package com.switchfully.eurder.service.mappers;

import com.switchfully.eurder.domain.models.Price;
import com.switchfully.eurder.service.dtos.PriceDTO;
import org.springframework.stereotype.Component;

@Component
public class PriceMapper {

    public Price toDomain(PriceDTO priceDTO) {
        return new Price(priceDTO.getAmount(), priceDTO.getCurrency());
    }

    public PriceDTO toDTO (Price price) {
        return new PriceDTO(price.getAmount(), price.getCurrency());

    }

}
