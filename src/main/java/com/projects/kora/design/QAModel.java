package com.projects.kora.design;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;


public class QAModel {
    @Column(name="created",nullable = false,updatable = false)
    private Date createdAt;

    @Column(name="updated",nullable=false)
    private Date updatedAt;

    @Column(name="user_id", nullable=false)
    private int userID;

    public QAModel(Date createdAt, Date updatedAt, int userID) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userID = userID;
    }

    public QAModel() {
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
