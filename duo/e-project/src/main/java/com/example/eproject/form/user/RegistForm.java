package com.example.eproject.form.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistForm {
    private String userName;
    private String LoginId;
    private String password;
}
