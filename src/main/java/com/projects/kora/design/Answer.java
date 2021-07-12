package com.projects.kora.design;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Answer extends QAModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ansId;

    @Column (name = "ans_body",nullable = false)
    private String ansBody;

    @Column(name="ques_id",nullable = false)
    private int quesId;

    @Column(columnDefinition = "integer default 0")
    private int upVoteSum;

    @Column(columnDefinition = "integer default 0")
    private int downVoteSum;

    public Answer() {

    }
    public Answer(Date createdAt, Date updatedAt, int userId, String ansBody, int quesId, int upVoteSum, int downVoteSum) {
        super(createdAt, updatedAt, userId);
        this.ansBody = ansBody;
        this.quesId = quesId;
        this.upVoteSum = upVoteSum;
        this.downVoteSum = downVoteSum;
    }

    public int getAnsId() {
        return ansId;
    }

    public void setAnsId(int ansId) {
        this.ansId = ansId;
    }

    public String getAnsBody() {
        return ansBody;
    }

    public void setAnsBody(String ansBody) {
        this.ansBody = ansBody;
    }

    public int getQuesId() {
        return quesId;
    }

    public void setQuesId(int quesId) {
        this.quesId = quesId;
    }

    public int getUpVoteSum() {
        return upVoteSum;
    }

    public void setUpVoteSum(int upVoteSum) {
        this.upVoteSum = upVoteSum;
    }

    public int getDownVoteSum() {
        return downVoteSum;
    }

    public void setDownVoteSum(int downVoteSum) {
        this.downVoteSum = downVoteSum;
    }
}
