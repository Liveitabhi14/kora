package com.projects.kora.design;

import javax.persistence.*;

@Entity
@Table
public class MyVote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int voteId;

    @Column(name = "ans_id",nullable = true)
    private int ansId;

    @Column(name="user_id",nullable = true)
    private int userId;

    @Column(name="upvote",nullable = true)
    private int upVote;

    @Column(name="downvote",nullable = true)
    private int downVote;

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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

    @Override
    public String toString() {
        return "MyVote{" +
                "voteId=" + voteId +
                ", ansId=" + ansId +
                ", userId=" + userId +
                ", upVote=" + upVote +
                ", downVote=" + downVote +
                '}';
    }
}
