package com.example.notification.sender;

import java.util.Map;
import java.util.Objects;

public final class PushSender implements NotificationSender {

    private final Map<String, String> config;

    public PushSender(Map<String, String> config) {
        this.config = Objects.requireNonNull(config, "config must not be null");
    }

    @Override
    public boolean send(String recipient, String subject, String body) {
        validate(recipient);
        System.out.printf("[Push] To: %s | Title: %s | Body: %s%n", recipient, subject, body);
        return true;
    }

    private void validate(String recipient) {
        if (recipient == null || recipient.isBlank()) {
            throw new IllegalArgumentException("Device id is required for push notifications");
        }
    }
}
