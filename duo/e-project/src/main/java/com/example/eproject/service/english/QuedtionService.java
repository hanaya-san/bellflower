package com.example.eproject.service.english;

import com.example.eproject.dao.english.QuestionDao;
import com.example.eproject.entity.english.QuestionEntity;
import com.example.eproject.response.english.QuestionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuedtionService {

    @Autowired
    private QuestionDao questionDao;

    public QuestionResponse findBySection(Integer section){
        List<QuestionEntity> questionList = questionDao.findBySection(section);

        return QuestionResponse.builder()
                .questionList(questionList)
                .build();
    }
}
