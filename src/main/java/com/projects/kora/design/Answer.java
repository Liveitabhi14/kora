package com.projects.kora.design;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="answer_table")
public class Answer extends QAModel{

    @Id
    private int id;

    @Column (name = "body")
    private String text;

    @Column(name="QID")
    private int qid;


    public Answer() {
    }

    public Answer(int id, String text, int qid) {
        this.id = id;
        this.text = text;
        this.qid = qid;
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

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }


}
