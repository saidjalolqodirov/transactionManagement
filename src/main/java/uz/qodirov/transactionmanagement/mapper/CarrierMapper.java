package uz.qodirov.transactionmanagement.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.qodirov.transactionmanagement.dto.carrier.CarrierCreateDTO;
import uz.qodirov.transactionmanagement.dto.carrier.CarrierDTO;
import uz.qodirov.transactionmanagement.dto.carrier.CarrierUpdateDTO;
import uz.qodirov.transactionmanagement.entity.Carrier;

/**
 * @author: Saidjalol Qodirov 2/5/2023 5:06 PM
 */
@Component
@Mapper(componentModel = "spring")
public interface CarrierMapper extends BaseMapper<CarrierDTO, Carrier, CarrierCreateDTO, CarrierUpdateDTO> {
}
