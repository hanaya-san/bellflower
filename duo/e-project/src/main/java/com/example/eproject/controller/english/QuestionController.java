package com.example.eproject.controller.english;

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
        QuestionResponse response = QuestionResponse.builder()
                .questionList(quedtionService.findBySection(section)).build();
        //System.out.println(response.getQuestionList().get(1).getJapanese());
        return response;
    }
}
