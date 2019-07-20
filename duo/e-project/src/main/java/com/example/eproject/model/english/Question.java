package com.example.eproject.model.english;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.PathVariable;

@Data
@Builder
public class Question {
    private Integer id;

    private String japanese;
}
