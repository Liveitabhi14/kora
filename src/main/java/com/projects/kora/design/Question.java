package com.projects.kora.design;

import javax.persistence.*;
//import javax.validation.constraints.NotNull;

@Entity
@Table
public class Question extends QAModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int quesId;

    @Column(name="ques_body",nullable = false)
    private String quesBody;



    public int getQuesId() {
        return quesId;
    }

    public void setQuesId(int quesId) {
        this.quesId = quesId;
    }

    public String getQuesBody() {
        return quesBody;
    }

    public void setQuesBody(String quesBody) {
        this.quesBody = quesBody;
    }
}
