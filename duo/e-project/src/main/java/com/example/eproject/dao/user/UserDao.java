package com.example.eproject.dao.user;

import com.example.eproject.entity.user.Authorize;
import com.example.eproject.entity.user.User;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@Dao
@ConfigAutowireable
public interface UserDao {

    @Select
    User findByUserId(Integer userId);

    @Insert
    int insertUser(User user);
}
