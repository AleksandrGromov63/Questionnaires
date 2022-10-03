package ru.ocode.questionnaires.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ocode.questionnaires.model.Issue;

public interface IssueRepository extends JpaRepository<Issue, Long> {
    Issue findByName(String name);

}
