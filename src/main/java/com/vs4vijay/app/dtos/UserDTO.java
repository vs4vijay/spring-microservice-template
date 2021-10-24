package com.vs4vijay.app.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {
    String id;

    String name;

    String email;

    Boolean isActive;

    Date createdAt;

    Date updatedAt;

    String createdBy;

    String updatedBy;
}
