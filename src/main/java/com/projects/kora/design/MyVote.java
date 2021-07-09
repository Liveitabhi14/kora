package com.projects.kora.design;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class MyVote {
    @Id
    private int voteId;

    @Column(name = "ans_id")
    private String ansId;

    @Column(name="ques_id")
    private int quesId;

    @Column(name="upvote")
    private int upvote;

    @Column(name="downvote")
    private int downvote;

    public MyVote() {
    }

    public MyVote(int voteId, String ansId, int quesId, int upvote, int downvote) {
        this.voteId = voteId;
        this.ansId = ansId;
        this.quesId = quesId;
        this.upvote = upvote;
        this.downvote = downvote;
    }

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public String getAnsId() {
        return ansId;
    }

    public void setAnsId(String ansId) {
        this.ansId = ansId;
    }

    public int getQuesId() {
        return quesId;
    }

    public void setQuesId(int quesId) {
        this.quesId = quesId;
    }

    public int getUpvote() {
        return upvote;
    }

    public void setUpvote(int upvote) {
        this.upvote = upvote;
    }

    public int getDownvote() {
        return downvote;
    }

    public void setDownvote(int downvote) {
        this.downvote = downvote;
    }
}
