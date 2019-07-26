package com.example.eproject.entity.user;

import lombok.Builder;
import lombok.Data;
import org.seasar.doma.*;

import java.util.HashMap;
import java.util.Map;


@Data
@Entity
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer users_id;

    private String user_name;

    public User() {
    }

    public User(Integer users_id, String user_name) {
        this.users_id = users_id;
        this.user_name = user_name;
    }

    public Map<String, String> getMap(){
        Map<String, String> map = new HashMap<>();
        map.put("user_id" , this.users_id.toString());
        map.put("user_name", this.user_name);
        return map;
    }
}
