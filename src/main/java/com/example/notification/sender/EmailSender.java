package com.example.notification.sender;

import java.util.Objects;

public final class EmailSender implements NotificationSender {

    private final String smtpServer;

    public EmailSender(String smtpServer) {
        this.smtpServer = Objects.requireNonNull(smtpServer, "smtpServer must not be null");
    }

    @Override
    public boolean send(String recipient, String subject, String body) {
        validate(recipient);
        System.out.printf("[Email] To: %s | Subject: %s | Body: %s%n", recipient, subject, body);
        return true;
    }

    private void validate(String recipient) {
        if (recipient == null || recipient.isBlank()) {
            throw new IllegalArgumentException("Email recipient is required");
        }
    }
}
