package com.example.eproject.service.user;

import com.example.eproject.dao.user.AuthorizeDao;
import com.example.eproject.dao.user.UserDao;
import com.example.eproject.entity.user.Authorize;
import com.example.eproject.entity.user.User;
import com.example.eproject.form.user.LoginForm;
import com.example.eproject.form.user.RegistForm;
import com.example.eproject.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private AuthorizeDao authorizeDao;

    @Transactional
    public void insertUserInfo(RegistForm registForm){
        User user = User.builder()
                .users_id(null)
                .user_name(registForm.getUserName())
                .build();

        userDao.insertUser(user);

        String loginId = registForm.getLoginId();
        String password = registForm.getPassword();
        String safetyPassword = PasswordUtil.getSafetyPassword(password , loginId);

        Authorize authorize = Authorize.builder()
                .authorize_local_id(null)
                .users_id(user.getUsers_id())
                .login_id(loginId)
                .password(safetyPassword)
                .build();

        authorizeDao.insertAuthorizaLocal(authorize);
    }

    public User findUser(LoginForm loginForm){
        String loginId = loginForm.getLoginId();
        String password = loginForm.getPassword();
        String safetyPassword = PasswordUtil.getSafetyPassword(password , loginId);

        Authorize authorize = authorizeDao.findAuthorize(loginId ,safetyPassword);
        if(authorize == null) {
            System.out.println("loginIdまたはパスワードが違います");
            throw new NullPointerException();
        }
        User user = userDao.findByUserId(authorize.getUsers_id());
        if (user == null){
            System.out.println("loginIdまたはパスワードが違います");
            throw new NullPointerException();
        }
        return user;
    }
}
