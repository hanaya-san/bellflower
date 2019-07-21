package com.example.eproject.response.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {

    private Integer users_id;

    private String user_name;

    private String userToken;
}
