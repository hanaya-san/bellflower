package com.example.eproject.service.english;

import com.example.eproject.dao.english.AnswerDao;
import com.example.eproject.model.english.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnswerService {
    @Autowired
    private AnswerDao answerDao;

    public List<Answer> findBySection(Integer section){
        List<Answer> answerList = answerDao.findBySection(section).stream().map(a -> Answer.builder().id(a.getId()).english(a.getEnglish()).build()).collect(Collectors.toList());
        return answerList;
    }
}
