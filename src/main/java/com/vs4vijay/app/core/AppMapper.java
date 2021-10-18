package com.vs4vijay.app.core;

import com.vs4vijay.app.dtos.CreateUserDTO;
import com.vs4vijay.app.dtos.UserDTO;
import com.vs4vijay.app.models.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppMapper {
    User toUser(UserDTO dto);

    User toUser(CreateUserDTO dto);

    UserDTO toUserDTO(User user);

    List<UserDTO> toUserDTOs(List<User> users);
}
