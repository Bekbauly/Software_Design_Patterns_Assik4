package com.example.notification.notification;

import com.example.notification.sender.NotificationSender;
import java.util.Objects;

public abstract class Notification {

    protected final NotificationSender sender;

    protected Notification(NotificationSender sender) {
        this.sender = Objects.requireNonNull(sender, "sender must not be null");
    }

    public final boolean notify(String recipient, NotificationContext context) {
        if (recipient == null || recipient.isBlank()) {
            throw new IllegalArgumentException("recipient must not be blank");
        }
        String subject = buildSubject(context);
        String body = buildBody(context);
        return sender.send(recipient, subject, body);
    }

    protected abstract String buildSubject(NotificationContext context);

    protected abstract String buildBody(NotificationContext context);
}
