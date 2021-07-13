package com.projects.kora.repository;


import com.projects.kora.design.Question;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
    List<Question> findByQuesId(Integer quesId);
}
