package uz.qodirov.transactionmanagement.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.qodirov.transactionmanagement.dto.region.RegionCreateDTO;
import uz.qodirov.transactionmanagement.dto.region.RegionDTO;
import uz.qodirov.transactionmanagement.dto.region.RegionUpdateDTO;
import uz.qodirov.transactionmanagement.entity.Region;

/**
 * @author: Saidjalol Qodirov 2/5/2023 11:02 AM
 */
@Component
@Mapper(componentModel = "spring")
public interface RegionMapper extends BaseMapper<RegionDTO, Region, RegionCreateDTO, RegionUpdateDTO> {
}
