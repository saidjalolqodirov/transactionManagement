package uz.qodirov.transactionmanagement.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.qodirov.transactionmanagement.dto.place.PlaceCreateDTO;
import uz.qodirov.transactionmanagement.dto.place.PlaceDTO;
import uz.qodirov.transactionmanagement.dto.place.PlaceUpdateDTO;
import uz.qodirov.transactionmanagement.entity.Place;

import java.util.List;

/**
 * @author: Saidjalol Qodirov 2/5/2023 9:40 AM
 */
@Component
@Mapper(componentModel = "spring")
public interface PlaceMapper extends BaseMapper<PlaceDTO, Place, PlaceCreateDTO, PlaceUpdateDTO> {

    @Override
    PlaceDTO toDto(Place entity);

    @Override
    Place fromCreateDto(PlaceCreateDTO createDto);

    @Override
    Place fromUpdateDto(PlaceUpdateDTO updateDto);

    @Override
    List<PlaceDTO> toDto(List<Place> entities);
}
