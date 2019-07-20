package com.example.eproject.dao.english;

import com.example.eproject.entity.english.AnswerEntity;
import com.example.eproject.entity.english.QuestionEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao
@ConfigAutowireable
public interface AnswerDao {

    @Select
    List<AnswerEntity> findBySection(Integer section);

}
