package com.example.notification.notification;

import com.example.notification.sender.NotificationSender;

public final class PromotionNotification extends Notification {

    public PromotionNotification(NotificationSender sender) {
        super(sender);
    }

    @Override
    protected String buildSubject(NotificationContext context) {
        return context.getOrDefault("headline", "Special Offer");
    }

    @Override
    protected String buildBody(NotificationContext context) {
        String offer = context.getOrDefault("offer", "Check our latest deals!");
        String code = context.getOrDefault("coupon", "");
        if (code.isBlank()) {
            return offer;
        }
        return offer + System.lineSeparator() + "Use code: " + code;
    }
}
