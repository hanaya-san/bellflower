package com.example.eproject.response.english;

import com.example.eproject.entity.english.AnswerEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AnswerResponse {

    private Integer score;
    private Integer totalScore;
    private List<AnswerEntity> answerList;
}
