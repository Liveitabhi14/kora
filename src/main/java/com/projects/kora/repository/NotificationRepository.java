package com.projects.kora.repository;

import com.projects.kora.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface NotificationRepository extends JpaRepository <Notification,Integer> {
    public List<Notification> findByUser1_userId(int user_id);

    @Transactional
    @Modifying
    @Query("update Notification n set n.seen = true where n.seen = false and n.user1.userId = :userId")
    void updateNotificationSeen(@Param("userId") Integer userId);
}
