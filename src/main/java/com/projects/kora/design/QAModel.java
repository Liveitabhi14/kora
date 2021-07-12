package com.projects.kora.design;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class QAModel {
    @Column(name="created_at",nullable = false,updatable = false)
    private Date createdAt;

    @Column(name="updated_at",nullable=false)
    private Date updatedAt;

    @Column(name="user_id", nullable=false)
    private int userId;

    public QAModel(Date createdAt, Date updatedAt, int userId) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userId = userId;
    }

    public QAModel() {
    }

    public Date getCreatedAt() {
        return createdAt;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
