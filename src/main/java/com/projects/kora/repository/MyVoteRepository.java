package com.projects.kora.repository;

import com.projects.kora.design.MyVote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyVoteRepository extends JpaRepository<MyVote,Integer> {

    MyVote findByAnsIdAndUserId(int ansId, int userId);
}
