package com.projects.kora.design;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projects.kora.auth.model.UserDAO;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

//    @Column(name="ques_id",nullable = false)
//    private int quesId;

    @Column(columnDefinition = "integer default 0")
    private int upVoteSum;

    @Column(columnDefinition = "integer default 0")
    private int downVoteSum;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ques_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Question question;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "user_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private UserDAO user1;
//
//    public UserDAO getUser() {
//        return user1;
//    }
//
//    public void setUser(UserDAO user1) {
//        this.user1 = user1;
//    }

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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
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
