package ru.ocode.questionnaires.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "questionnaires")
@Getter
@Setter
@NoArgsConstructor
public class Questionnaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 1, message = "не менее одного символа")
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "questionnaire")
    @Size(min = 1, message = "Не менее одного вопроса!")
    private List<Issue> issues;
}
