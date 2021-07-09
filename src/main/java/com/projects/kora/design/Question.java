package com.projects.kora.design;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.NotNull;

@Entity
@Table(name="question_table")
public class Question extends QAModel{
    @Id
    private int qid;

    //@NotNull
    @Column(name="body")
    private String text;

    public Question(int qid, String text) {
        this.qid = qid;
        this.text = text;
    }

    public Question() {
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
