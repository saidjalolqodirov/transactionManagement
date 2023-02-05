package uz.qodirov.transactionmanagement.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.qodirov.transactionmanagement.dto.offer.OfferCreateDTO;
import uz.qodirov.transactionmanagement.dto.offer.OfferDTO;
import uz.qodirov.transactionmanagement.dto.offer.OfferUpdateDTO;
import uz.qodirov.transactionmanagement.entity.Offer;

/**
 * @author: Saidjalol Qodirov 2/5/2023 7:43 PM
 */
@Component
@Mapper(componentModel = "spring")
public interface OfferMapper extends BaseMapper<OfferDTO, Offer, OfferCreateDTO, OfferUpdateDTO> {
}
