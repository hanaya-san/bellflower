package com.example.eproject.response.english;

import com.example.eproject.entity.english.QuestionEntity;
import com.example.eproject.model.english.Question;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class QuestionResponse {

    private List<Question> questionList;
}
