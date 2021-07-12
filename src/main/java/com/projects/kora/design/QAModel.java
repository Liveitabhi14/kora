package com.projects.kora.design;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class QAModel {

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name="created_at",nullable = true,updatable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name="updated_at",nullable=true)
    private Date updatedAt;

    @Column(name="user_id", nullable=true)
    private int userId;


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
