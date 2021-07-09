package com.projects.kora.repository;


import com.projects.kora.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
}
