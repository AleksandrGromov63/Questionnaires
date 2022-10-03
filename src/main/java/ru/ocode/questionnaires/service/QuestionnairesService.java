package ru.ocode.questionnaires.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import ru.ocode.questionnaires.model.Answer;
import ru.ocode.questionnaires.model.Issue;
import ru.ocode.questionnaires.model.Questionnaire;
import ru.ocode.questionnaires.repository.AnswerRepository;
import ru.ocode.questionnaires.repository.IssueRepository;
import ru.ocode.questionnaires.repository.QuestionnairesRepository;

import java.util.*;

@Service
public class QuestionnairesService {

    @Autowired
    QuestionnairesRepository questionnairesRepository;
    @Autowired
    IssueRepository issueRepository;
    @Autowired
    AnswerRepository answerRepository;

    public Questionnaire getById(Long id) {
        Optional<Questionnaire> questionnaireFromDB = questionnairesRepository.findById(id);
        return questionnaireFromDB.orElse(new Questionnaire());
    }

    public List<Questionnaire> getAllQuestionnaire() {
        return questionnairesRepository.findAll();
    }

   /* public boolean saveQuestionnaire(Questionnaire questionnaire) {
        Questionnaire questionnaireFromDB = questionnairesRepository.findQuestionnaireByName(questionnaire.getName());
        if (questionnaireFromDB != null) {
            questionnaire.setName(questionnaire.getName());
            //questionnaire.setNumberOfIssues(questionnaire.getNumberOfIssues());
            questionnairesRepository.save(questionnaire);
            return true;
        }
        questionnaire.setName(questionnaire.getName());
        //questionnaire.setNumberOfIssues(questionnaire.getNumberOfIssues());
        questionnairesRepository.save(questionnaire);
        return true;
    }*/

    public boolean saveQuestionnaire(String name, MultiValueMap<String, String> issues) {
      /*  Questionnaire questionnaireFromDB = questionnairesRepository.findQuestionnaireByName(name);

        if (questionnaireFromDB != null) {
            questionnaireFromDB.setName(name);

            List<Issue> issueList = new ArrayList<>();
            for (String question : issues) {
                Issue issue = new Issue();
                //issue.setQuestionnaire(questionnaireFromDB);
                issue.setName(question);
            }

            questionnaireFromDB.setIssues(issueList);
            questionnairesRepository.save(questionnaireFromDB);
            return true;
        }*/

        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setName(name);

        List<Issue> issueList = new ArrayList<>();

        for(Map.Entry<String, List<String>> issueEntry : issues.entrySet()){
            Issue issue = new Issue();
            issue.setName(issueEntry.getKey());
            issue.setQuestionnaire(questionnaire);

            List<Answer> answers = new ArrayList<>();

            for(String answer : issueEntry.getValue()){
                Answer answerToQuestion = new Answer();
                answerToQuestion.setName(answer);
                answerToQuestion.setIssue(issue);
                answerRepository.save(answerToQuestion);

                answers.add(answerToQuestion);
            }

            issue.setAnswers(answers);
            issueRepository.save(issue);

            issueList.add(issue);
            System.out.println(issueEntry.getKey() + " " + issueEntry.getValue().stream().iterator().next().toUpperCase(Locale.ROOT));
        }
 /*       for (String question : issues) {
            Issue issue = new Issue();
            issue.setQuestionnaire(questionnaire);
            issue.setName(question);
            issueRepository.save(issue);
        }*/

        questionnaire.setIssues(issueList);
        questionnairesRepository.save(questionnaire);
        return true;
    }

    public boolean deleteQuestionnaire(Long questionnaireId) {
        if (questionnairesRepository.findById(questionnaireId).isPresent()) {
            questionnairesRepository.deleteById(questionnaireId);
            return true;
        }
        return false;
    }
}
