package ru.ocode.questionnaires.model;

import lombok.*;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "issues")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 1, message = "Не менее одного символа!")
    private String name;
    // @Size(min = 2, message = "Не менее двух вариантов ответа")
   /* @ElementCollection
    private List<String> answerChoices;*/
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    /*   @JoinColumn(name = "questionnaire_id", nullable = false)*/
    private Questionnaire questionnaire;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "issue")
    private List<Answer> answers;
}
