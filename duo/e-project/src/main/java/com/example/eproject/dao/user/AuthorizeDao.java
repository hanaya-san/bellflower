package com.example.eproject.dao.user;

import com.example.eproject.entity.user.Authorize;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@Dao
@ConfigAutowireable
public interface AuthorizeDao {

    @Select
    Authorize findAuthorize(String loginId , String password);

    @Insert
    int insertAuthorizaLocal(Authorize authorize);
}
