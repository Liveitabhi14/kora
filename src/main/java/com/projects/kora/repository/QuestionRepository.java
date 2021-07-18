package com.projects.kora.repository;


import com.projects.kora.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
    Question findByQuesId(Integer quesId);
}
