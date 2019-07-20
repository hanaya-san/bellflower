package com.example.eproject.service.english;

import com.example.eproject.dao.english.QuestionDao;
import com.example.eproject.entity.english.QuestionEntity;
import com.example.eproject.model.english.Question;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuedtionService {

    @Autowired
    private QuestionDao questionDao;

    public List<Question> findBySection(Integer section){
        List<Question> questionList = questionDao.findBySection(section).stream().map(q -> Question.builder().id(q.getId()).japanese(q.getJapanese()).build()).collect(Collectors.toList());
        return questionList;
    }
}
