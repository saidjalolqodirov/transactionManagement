package uz.qodirov.transactionmanagement.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.qodirov.transactionmanagement.dto.request.RequestCreateDTO;
import uz.qodirov.transactionmanagement.dto.request.RequestDTO;
import uz.qodirov.transactionmanagement.dto.request.RequestUpdateDTO;
import uz.qodirov.transactionmanagement.entity.Request;

/**
 * @author: Saidjalol Qodirov 2/5/2023 7:13 PM
 */
@Component
@Mapper(componentModel = "spring")
public interface RequestMapper extends BaseMapper<RequestDTO, Request, RequestCreateDTO, RequestUpdateDTO> {
}
