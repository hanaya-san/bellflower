package com.example.eproject.response.english;

import com.example.eproject.entity.english.AnswerEntity;
import com.example.eproject.model.english.Answer;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AnswerResponse {

    private Integer score;
    private Integer totalScore;
    private List<Answer> answerList;
}
