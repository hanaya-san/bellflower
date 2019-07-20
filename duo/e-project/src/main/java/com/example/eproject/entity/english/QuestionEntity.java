package com.example.eproject.entity.english;

import lombok.Data;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;

@Entity
@Data
public class QuestionEntity {
    @Id
    private Integer id;

    private String japanese;
}
