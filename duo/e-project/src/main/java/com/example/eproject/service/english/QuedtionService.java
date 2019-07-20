package com.example.eproject.service.english;

import com.example.eproject.dao.english.QuestionDao;
import com.example.eproject.entity.english.QuestionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuedtionService {

    @Autowired
    private QuestionDao questionDao;

    public List<QuestionEntity> findBySection(Integer section){
        return questionDao.findBySection(section);
    }
}
