package com.projects.kora.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projects.kora.auth.model.UserDAO;
import org.hibernate.annotations.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int notificationId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private UserDAO user1;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "event_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Event event;

    @Any(metaColumn = @Column(name = "postType"))
    @AnyMetaDef(idType = "int", metaType = "string",
            metaValues = {
                    @MetaValue(targetEntity = Question.class, value = "question"),
                    @MetaValue(targetEntity = Answer.class, value = "answer")
            })
    @Cascade( { org.hibernate.annotations.CascadeType.ALL})
    @JoinColumn(name = "post_Id")
    private QAModel post;

    @Column(columnDefinition = "boolean default false")
    private boolean seen;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name="created_at",nullable = true,updatable = false)
    private Date createdAt;

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public UserDAO getUser1() {
        return user1;
    }

    public void setUser1(UserDAO user1) {
        this.user1 = user1;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public QAModel getPost() {
        return post;
    }

    public void setPost(QAModel post) {
        this.post = post;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
