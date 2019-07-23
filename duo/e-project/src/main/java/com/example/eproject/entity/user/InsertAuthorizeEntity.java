package com.example.eproject.entity.user;

import lombok.Builder;
import lombok.Data;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;
import org.seasar.doma.boot.ConfigAutowireable;

@Entity
@Data
@Builder
@ConfigAutowireable
@Table(name = "authorize_local")
public class InsertAuthorizeEntity {

    private String login_id;

    private String password;

    public InsertAuthorizeEntity() {
    }

    public InsertAuthorizeEntity(String login_id, String password) {
        this.login_id = login_id;
        this.password = password;
    }
}
