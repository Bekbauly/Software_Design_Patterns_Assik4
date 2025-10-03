package com.example.notification.notification;

import com.example.notification.sender.NotificationSender;

public final class ReminderNotification extends Notification {

    public ReminderNotification(NotificationSender sender) {
        super(sender);
    }

    @Override
    protected String buildSubject(NotificationContext context) {
        return "Reminder: " + context.getOrDefault("title", "Upcoming");
    }

    @Override
    protected String buildBody(NotificationContext context) {
        String time = context.getOrDefault("time", "unspecified time");
        String message = context.getOrDefault("message", "");
        return String.format("At %s: %s", time, message);
    }
}
