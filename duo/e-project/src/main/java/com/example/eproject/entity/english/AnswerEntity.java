package com.example.eproject.entity.english;

import lombok.Builder;
import lombok.Data;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;

@Data
@Entity
public class AnswerEntity {

    @Id
    private Integer id;

    private String english;
}
