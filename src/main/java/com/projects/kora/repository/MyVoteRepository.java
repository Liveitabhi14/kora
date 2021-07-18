package com.projects.kora.repository;

import com.projects.kora.model.MyVote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MyVoteRepository extends JpaRepository<MyVote,Integer> {

    @Query("")
    MyVote findByAnswer_ansIdAndUser1_userId(int ansId, int userId);
}
