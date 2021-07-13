package com.projects.kora.repository;


import com.projects.kora.design.Answer;
import com.projects.kora.design.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer,Integer> {
    List<Answer> findByQuestion_quesId(int quesId);

    Answer findByAnsId(int ansId);

    List<Answer> findTop5ByQuestion_quesIdOrderByUpVoteSumDesc(int i);

//    @Query("SELECT DISTINCT Question from Answer")
//    List<Question> findAllDistinctQuesId();
}

