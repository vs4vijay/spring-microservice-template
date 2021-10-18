package com.vs4vijay.app.controllers;

import com.vs4vijay.app.core.AppMapper;
import com.vs4vijay.app.models.User;
import com.vs4vijay.app.services.UserService;
import com.vs4vijay.app.dtos.CreateUserDTO;
import com.vs4vijay.app.dtos.UserDTO;
import com.vs4vijay.app.errors.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Validated
@RequestMapping("/users")
@RestController()
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AppMapper mapper;

    @GetMapping("")
    public List<UserDTO> getAll() {
        List<User> users = userService.getAll();
        List<UserDTO> userDTOs = mapper.toUserDTOs(users);
        return userDTOs;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public UserDTO create(@Valid @RequestBody CreateUserDTO userDTO) {
        User user = mapper.toUser(userDTO);
        User createdUser = userService.create(user);
        UserDTO createdUserDTO = mapper.toUserDTO(createdUser);
        return createdUserDTO;
    }

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable("id") UUID id) {
        Optional<User> byId = userService.getById(id);
        if(byId.isPresent()) {
            UserDTO userDTO = mapper.toUserDTO(byId.get());
            return userDTO;
        } else {
            throw new ResourceNotFoundException(id.toString());
        }
    }

    @PutMapping("/{id}")
    public UserDTO update(@PathVariable("id") UUID id, @RequestBody CreateUserDTO userDTO) {
        // TODO: Check if valid user
        User user = mapper.toUser(userDTO);
        // TODO: Partial Update
        User updatedUser = userService.update(id, user);
        UserDTO updatedUserDTO = mapper.toUserDTO(updatedUser);
        return updatedUserDTO;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        userService.delete(id);
    }
}
