package com.example.eproject.controller.english;

import com.example.eproject.dao.english.AnswerDao;
import com.example.eproject.entity.english.AnswerEntity;
import com.example.eproject.form.english.AnswerForm;
import com.example.eproject.model.english.Answer;
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

        String correctentence = "正解";

        List<Answer> correctAnswerList = answerService.findBySection(section);

        List<String> userAnswerList = answerForm.getResponseAnswers();

        Integer totalScore = (int)correctAnswerList.stream().count();

        List<Answer> answer = IntStream.range(0, correctAnswerList.size()).mapToObj(i ->
                        !correctAnswerList.get(i).getEnglish().replaceAll(" ","").equals(userAnswerList.get(i).replaceAll(" ","")) ?
                                correctAnswerList.get(i) : Answer.builder().id(correctAnswerList.get(i).getId()).english(correctentence).build()).collect(Collectors.toList());

        Integer score = (int)answer.stream().map(a -> a.getEnglish()).filter(e -> e.equals(correctentence)).count();

        return AnswerResponse.builder().
                score(score).
                totalScore(totalScore).
                answerList(answer).
                build();
    }
}
