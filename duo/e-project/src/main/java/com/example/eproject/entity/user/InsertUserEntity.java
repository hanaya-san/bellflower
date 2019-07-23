package com.example.eproject.entity.user;

import lombok.Builder;
import lombok.Data;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;

@Entity
@Data
@Builder
@Table(name = "users")
public class InsertUserEntity {

    private String user_name;

    public InsertUserEntity() {
    }

    public InsertUserEntity(String user_name) {
        this.user_name = user_name;
    }
}
