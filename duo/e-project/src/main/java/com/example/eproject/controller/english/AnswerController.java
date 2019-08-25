package com.example.eproject.controller.english;

import com.example.eproject.entity.english.AnswerEntity;
import com.example.eproject.form.english.AnswerForm;
import com.example.eproject.response.english.AnswerResponse;
import com.example.eproject.service.english.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@CrossOrigin
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;
    @RequestMapping(value = "/{section}" , method = RequestMethod.POST)
    public AnswerResponse findBySection(@RequestBody AnswerForm answerForm, @PathVariable("section") Integer section){

        return answerService.findBySection(section, answerForm);
    }
}
