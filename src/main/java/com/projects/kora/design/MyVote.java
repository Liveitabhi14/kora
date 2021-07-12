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

    @Column(name="user_id",nullable = false)
    private int userId;

    @Column(name="upvote",nullable = false)
    private int upVote = 0;

    @Column(name="downvote",nullable = false)
    private int downVote = 0;

    public MyVote() {
        this.upVote = 0;
        this.downVote = 0;
    }

    public MyVote(int voteId, int ansId, int userId, int upVote, int downVote) {
        this.voteId = voteId;
        this.ansId = ansId;
        this.userId = userId;
        this.upVote = upVote;
        this.downVote = downVote;
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

    public void setQuesId(int userId) {
        this.userId = userId;
    }

    public int getUpVote() {
        return upVote;
    }

    public void setUpVote(int upVote) {
        this.upVote = upVote;
    }

    public int getDownVote() {
        return downVote;
    }

    public void setDownVote(int downVote) {
        this.downVote = downVote;
    }
}
