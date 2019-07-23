package com.example.eproject.dao.user;

import com.example.eproject.entity.user.InsertAuthorizeEntity;
import com.example.eproject.entity.user.InsertUserEntity;
import com.example.eproject.entity.user.UserEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao
@ConfigAutowireable
public interface UserDao {

    @Select
    UserEntity findByLoginId(String loginId);

    @Insert
    int insertUser(InsertUserEntity insertUserEntity);

    @Insert(sqlFile = true)
    int insertAuthorize(InsertAuthorizeEntity insertAuthorizeEntity);


}
