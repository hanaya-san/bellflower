package com.example.eproject.controller.user;

import com.example.eproject.entity.user.User;
import com.example.eproject.form.user.LoginForm;
import com.example.eproject.form.user.RegistForm;
import com.example.eproject.response.user.UserResponse;
import com.example.eproject.service.user.UserService;
import com.example.eproject.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public void userRegist(@RequestBody RegistForm registForm){
        userService.insertUserInfo(registForm);
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public UserResponse userLogin(@RequestBody LoginForm loginForm){
        User user = userService.findUser(loginForm);
        String userToken = TokenUtil.getCsrfToken();

        redisTemplate.opsForHash().putAll(userToken, user.getMap());

        return UserResponse.builder()
                .users_id(user.getUsers_id())
                .user_name(user.getUser_name())
                .userToken(userToken)
                .build();
    }
}
