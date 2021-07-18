package com.projects.kora.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cat_name", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

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
