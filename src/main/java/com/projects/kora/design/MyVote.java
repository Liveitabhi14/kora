package com.projects.kora.design;

import javax.persistence.*;

@Entity
@Table
public class MyVote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int voteId;

    @Column(name = "ans_id",nullable = false,default = 0)
    private int ansId;

    @Column(name="user_id",nullable = false)
    private int userId;

    @Column(name="upvote",nullable = false)
    private int upvote;

    @Column(name="downvote",nullable = false)
    private int downvote;

    public MyVote() {
        this.upvote = 0;
        this.downvote = 0;
    }

    public MyVote(int voteId, int ansId, int userId, int upvote, int downvote) {
        this.voteId = voteId;
        this.ansId = ansId;
        this.userId = userId;
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
        return userId;
    }

    public void setQuesId(int quesId) {
        this.userId = quesId;
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
