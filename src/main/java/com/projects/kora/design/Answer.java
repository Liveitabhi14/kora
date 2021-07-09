package com.projects.kora.design;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
public class Answer extends QAModel{

    @Id
    private int ansId;

    @Column (name = "ans_body")
    private String ansBody;

    @Column(name="ques_id")
    private int quesId;


    public Answer() {
    }

    public Answer(Date createdAt, Date updatedAt, int userID, int ansId, String ansBody, int quesId) {
        super(createdAt, updatedAt, userID);
        this.ansId = ansId;
        this.ansBody = ansBody;
        this.quesId = quesId;
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

    public void setQuesId(int queId) {
        this.quesId = queId;
    }
}
