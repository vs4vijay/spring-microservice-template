package com.vs4vijay.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity()
@Data()
@NoArgsConstructor()
@AllArgsConstructor()
public class User extends BaseModel {
    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String email;
}
