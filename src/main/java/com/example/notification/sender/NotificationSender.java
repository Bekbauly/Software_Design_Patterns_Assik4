package com.example.notification.sender;

public interface NotificationSender {
    boolean send(String recipient, String subject, String body);
}
