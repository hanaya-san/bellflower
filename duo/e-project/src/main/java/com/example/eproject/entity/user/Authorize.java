package com.example.eproject.entity.user;

import lombok.Builder;
import lombok.Data;
import org.seasar.doma.*;

@Data
@Entity
@Builder
@Table(name = "authorize_local")
public class Authorize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorize_local_id;
    private Integer users_id;
    private String login_id;
    private String password;

    public Authorize() {
    }

    public Authorize(Integer authorize_local_id, Integer users_id, String login_id, String password) {
        this.authorize_local_id = authorize_local_id;
        this.users_id = users_id;
        this.login_id = login_id;
        this.password = password;
    }
}
