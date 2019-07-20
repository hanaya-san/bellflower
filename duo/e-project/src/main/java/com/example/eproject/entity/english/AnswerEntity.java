package com.example.eproject.entity.english;

import lombok.Builder;
import lombok.Data;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;

@Data
@Entity
@Builder
public class AnswerEntity {

    @Id
    private Integer id;

    private String englishText;

    public AnswerEntity() {
    }

    public AnswerEntity(Integer id, String englishText) {
        this.id = id;
        this.englishText = englishText;
    }
}
