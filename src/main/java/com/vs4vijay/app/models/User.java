package com.vs4vijay.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;

@Entity()
@Data()
@NoArgsConstructor()
@AllArgsConstructor()
@SQLDelete(sql = "UPDATE user SET is_deleted = true WHERE id = ?")
@Where(clause = BaseModel.SOFT_DELETE_CLAUSE)
public class User extends BaseModel {
    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String email;

    @Column()
    Boolean isActive;

    @PrePersist
    private void onGameCreate() {
        this.isActive = true;
    }
}
