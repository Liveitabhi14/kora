package com.projects.kora.service;

import com.projects.kora.auth.config.JwtTokenUtil;
import com.projects.kora.auth.model.UserDAO;
import com.projects.kora.model.Notification;
import com.projects.kora.auth.repository.UserRepository;
import com.projects.kora.auth.service.AuthUserDetailsService;
import com.projects.kora.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Autowired
    AuthUserDetailsService authUserDetailsService;
    @Autowired
    NotificationRepository notificationRepository;

    private int getUserId() { return authUserDetailsService.getUserIdByUsername(jwtTokenUtil.username); }

    public List<Notification> userNotification() {
        int user_id = getUserId();
        return notificationRepository.findByUser1_userId(user_id);
    }
}
