package com.example.eproject.service.user;

import com.example.eproject.dao.user.UserDao;
import com.example.eproject.entity.user.InsertAuthorizeEntity;
import com.example.eproject.entity.user.InsertUserEntity;
import com.example.eproject.entity.user.UserEntity;
import com.example.eproject.form.user.LoginForm;
import com.example.eproject.form.user.RegistForm;
import com.example.eproject.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void insertUserInfo(RegistForm registForm){
        InsertUserEntity insertUserEntity = InsertUserEntity.builder()
                .user_name(registForm.getUserName())
                .build();

        userDao.insertUser(insertUserEntity);

        String loginId = registForm.getLoginId();
        String password = registForm.getPassword();
        String safetyPassword = PasswordUtil.getSafetyPassword(password , loginId);

        InsertAuthorizeEntity insertAuthorizeEntity = InsertAuthorizeEntity.builder()
                .login_id(loginId)
                .password(safetyPassword)
                .build();

        userDao.insertAuthorize(insertAuthorizeEntity);
    }

    public UserEntity findUser(LoginForm loginForm){
        String loginId = loginForm.getLoginId();
        String password = loginForm.getPassword();
        String safetyPassword = PasswordUtil.getSafetyPassword(password , loginId);

        UserEntity userEntity = userDao.findByLoginId(loginId);

        if (userEntity == null){
            System.out.println("ユーザーが見つかりません");
            throw new NullPointerException();
        }else if(!userEntity.getPassword().equals(safetyPassword)){
            System.out.println("登録されたパスワードと一致しません");
            throw new NullPointerException();
        }else {
            return userEntity;
        }
    }
}
