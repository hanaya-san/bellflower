package com.example.eproject.controller.english;

import com.example.eproject.response.english.QuestionResponse;
import com.example.eproject.service.english.QuedtionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuedtionService quedtionService;

    @RequestMapping(value = "/{section}" ,method = RequestMethod.GET)
    public QuestionResponse findBySection(@PathVariable("section") Integer section){
        return quedtionService.findBySection(section);
    }
}
