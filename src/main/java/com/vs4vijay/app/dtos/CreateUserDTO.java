package com.vs4vijay.app.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateUserDTO {
    @NotBlank
    String name;

    @NotBlank
    String email;

    Boolean isActive;
}
