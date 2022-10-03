package ru.ocode.questionnaires.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ocode.questionnaires.model.Questionnaire;

public interface QuestionnairesRepository extends JpaRepository<Questionnaire, Long> {
    Questionnaire findQuestionnaireByName(String questionnaireName);
}
