package com.example.notification.notification;

import java.util.Map;
import java.util.Objects;

public final class NotificationContext {
    private final Map<String, String> data;

    public NotificationContext(Map<String, String> data) {
        this.data = Objects.requireNonNull(data);
    }

    public String get(String key) {
        return data.get(key);
    }

    public String getOrDefault(String key, String defaultValue) {
        return data.getOrDefault(key, defaultValue);
    }
}
