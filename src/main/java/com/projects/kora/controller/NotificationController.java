package com.projects.kora.controller;

import com.projects.kora.model.Notification;
import com.projects.kora.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NotificationController {
    @Autowired
    NotificationService notificationService;

    @GetMapping ("/kora/notification")
    private List<Notification> userNotification() {
        return notificationService.userNotification();

    }
}
