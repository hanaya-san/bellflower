package com.example.eproject.service.english;

import com.example.eproject.dao.english.AnswerDao;
import com.example.eproject.entity.english.AnswerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {
    @Autowired
    private AnswerDao answerDao;

    public List<AnswerEntity> findBySection(Integer section){
        return answerDao.findBySection(section);
    }
}
