package ru.ocode.questionnaires.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ocode.questionnaires.model.Answer;
import ru.ocode.questionnaires.model.Issue;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Answer findByName(String name);
    List<Answer> findByIssue(Issue issue);
}
