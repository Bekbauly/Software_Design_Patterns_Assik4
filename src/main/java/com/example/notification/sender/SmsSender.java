package com.example.notification.sender;

import java.util.Objects;

public final class SmsSender implements NotificationSender {

    private final String gatewayUrl;

    public SmsSender(String gatewayUrl) {
        this.gatewayUrl = Objects.requireNonNull(gatewayUrl, "gatewayUrl must not be null");
    }

    @Override
    public boolean send(String recipient, String subject, String body) {
        validate(recipient);
        System.out.printf("[SMS] To: %s | Message: %s%n", recipient, body);
        return true;
    }

    private void validate(String recipient) {
        if (recipient == null || recipient.isBlank()) {
            throw new IllegalArgumentException("Phone number is required for SMS");
        }
    }
}
