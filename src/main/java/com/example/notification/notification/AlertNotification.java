package com.example.notification.notification;

import com.example.notification.sender.NotificationSender;

public final class AlertNotification extends Notification {

    public AlertNotification(NotificationSender sender) {
        super(sender);
    }

    @Override
    protected String buildSubject(NotificationContext context) {
        return context.getOrDefault("title", "Important");
    }

    @Override
    protected String buildBody(NotificationContext context) {
        String message = context.getOrDefault("message", "No details provided.");
        String severity = context.getOrDefault("severity", "");
        return String.format("%s%n%s", severity, message).trim();
    }
}
