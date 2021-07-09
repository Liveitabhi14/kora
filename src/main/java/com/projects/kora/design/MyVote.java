package com.projects.kora.design;

import javax.persistence.*;

@Entity
@Table
public class MyVote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int voteId;

    @Column(name = "ans_id",nullable = false)
    private int ansId;

    @Column(name="ques_id",nullable = false)
    private int quesId;

    @Column(name="upvote",nullable = false)
    private int upvote;

    @Column(name="downvote",nullable = false)
    private int downvote;

    public MyVote() {
        this.upvote = 0;
        this.downvote = 0;
    }

    public MyVote(int voteId, int ansId, int quesId, int upvote, int downvote) {
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

    public int getAnsId() {
        return ansId;
    }

    public void setAnsId(int ansId) {
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
