package com.example.eproject.service.english;

import com.example.eproject.dao.english.AnswerDao;
import com.example.eproject.entity.english.AnswerEntity;
import com.example.eproject.form.english.AnswerForm;
import com.example.eproject.response.english.AnswerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class AnswerService {
    @Autowired
    private AnswerDao answerDao;

    public AnswerResponse findBySection(Integer section , AnswerForm answerForm){
        String correctentence = "正解";

        List<AnswerEntity> answerObjList = answerDao.findBySection(section);

        List<Integer> idList = answerObjList.stream()
                .map(_answer -> _answer.getId())
                .collect(Collectors.toList());

        List<String> correctAnswerList = answerObjList.stream()
                .map(_answer -> _answer.getEnglishText().replaceAll(" ", ""))
                .collect(Collectors.toList());

        List<String> userAnswerList = answerForm.getResponseAnswers().stream()
                .map(_answer -> _answer.replaceAll(" ",""))
                .collect(Collectors.toList());

        Integer totalScore = (int)idList.stream().count();

        List<AnswerEntity> answerList = IntStream.range(0, correctAnswerList.size()).mapToObj(_index ->
                !correctAnswerList.get(_index).equals(userAnswerList.get(_index)) ?
                        answerObjList.get(_index) : AnswerEntity.builder().id(idList.get(_index)).englishText(correctentence).build())
                .collect(Collectors.toList());

        Integer score = (int)answerList.stream().map(a -> a.getEnglishText()).filter(e -> e.equals(correctentence)).count();

        return AnswerResponse.builder()
                .score(score)
                .totalScore(totalScore)
                .answerList(answerList)
                .build();
    }
}
