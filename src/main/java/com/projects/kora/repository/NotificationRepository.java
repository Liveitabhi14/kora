package com.projects.kora.repository;

import com.projects.kora.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository <Notification,Integer> {
    public List<Notification> findByUser1_userId(int user_id);
}
