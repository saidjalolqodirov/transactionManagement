package uz.qodirov.transactionmanagement.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.qodirov.transactionmanagement.dto.auth.RegisterDTO;
import uz.qodirov.transactionmanagement.dto.user.UserCreateDTO;
import uz.qodirov.transactionmanagement.dto.user.UserDTO;
import uz.qodirov.transactionmanagement.dto.user.UserUpdateDTO;
import uz.qodirov.transactionmanagement.entity.Users;

/**
 * @author: Saidjalol Qodirov 2/5/2023 7:46 AM
 */

@Component
@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<UserDTO, Users, UserCreateDTO, UserUpdateDTO> {

    Users fromRegisterDTO(RegisterDTO registerDTO);

}
