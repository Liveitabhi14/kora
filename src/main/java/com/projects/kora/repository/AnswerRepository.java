package com.projects.kora.repository;


import com.projects.kora.design.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer,Integer> {
//    List<Answer> findByquesId(int quesId);
//
    Answer findByAnsId(int ansId);
//
//    List<Answer> findTop5ByQuesIdOrderByUpVoteSumDesc(int i);
//
//    @Query("SELECT DISTINCT quesId from Answer")
//    List<Integer> findAllDistinctQuesId();
}

