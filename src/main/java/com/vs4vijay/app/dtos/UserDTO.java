package com.vs4vijay.app.dtos;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class UserDTO {
    UUID id;

    String name;

    String email;

    Boolean isActive;

    Date createdAt;

    Date updatedAt;

    String createdBy;

    String updatedBy;
}
