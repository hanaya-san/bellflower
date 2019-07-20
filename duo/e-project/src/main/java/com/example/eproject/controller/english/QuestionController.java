package com.example.eproject.controller.english;

import com.example.eproject.entity.english.QuestionEntity;
import com.example.eproject.response.english.QuestionResponse;
import com.example.eproject.service.english.QuedtionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuedtionService quedtionService;

    @RequestMapping(value = "/{section}" ,method = RequestMethod.GET)
    public QuestionResponse findBySection(@PathVariable("section") Integer section){

        List<QuestionEntity> questionList = quedtionService.findBySection(section);

        return QuestionResponse.builder()
                .questionList(questionList)
                .build();
    }
}
