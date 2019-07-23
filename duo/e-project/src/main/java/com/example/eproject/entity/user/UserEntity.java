package com.example.eproject.entity.user;

import lombok.Builder;
import lombok.Data;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Data
@Entity
@Builder
public class UserEntity {

    @Id
    private Integer users_id;

    private String user_name;

    private String login_id;

    private String password;

    public UserEntity() {
    }

    public UserEntity(Integer users_id, String user_name, String login_id, String password) {
        this.users_id = users_id;
        this.user_name = user_name;
        this.login_id = login_id;
        this.password = password;
    }

    public Map<String ,String> getMap(){
        Map<String ,String> map = new HashMap<>();
        map.put("users_id", this.users_id.toString());
        map.put("user_name", this.user_name);
        return map;
    }
}
