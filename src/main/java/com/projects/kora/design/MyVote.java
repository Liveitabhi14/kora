package com.projects.kora.design;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="my_vote_table")
public class MyVote {
    @Id
    private int id;

    @Column(name = "ans_id")
    private String text;

    @Column(name="q_id")
    private int qId;

    @Column(name="upvote")
    private int upVote;

    @Column(name="downvote")
    private int downVote;

    public MyVote() {
    }

    public MyVote(int id, String text, int qId, int upVote, int downVote) {
        this.id = id;
        this.text = text;
        this.qId = qId;
        this.upVote = upVote;
        this.downVote = downVote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getqId() {
        return qId;
    }

    public void setqId(int qId) {
        this.qId = qId;
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
