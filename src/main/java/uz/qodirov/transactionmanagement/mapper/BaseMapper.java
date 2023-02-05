package uz.qodirov.transactionmanagement.mapper;

import uz.qodirov.transactionmanagement.dto.BaseDTO;
import uz.qodirov.transactionmanagement.dto.GenericDTO;
import uz.qodirov.transactionmanagement.entity.BaseEntity;

import java.util.List;

/**
 * @author: Saidjalol Qodirov 2/4/2023 11:32 PM
 */
public interface BaseMapper<D extends GenericDTO, E extends BaseEntity, CD extends BaseDTO, UD extends GenericDTO> extends Mapper {

    D toDto(E entity);

    E fromCreateDto(CD createDto);

    E fromUpdateDto(UD updateDto);

    List<D> toDto(List<E> entities);
}
