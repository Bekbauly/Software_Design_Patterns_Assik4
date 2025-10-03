package com.example.notification;

import com.example.notification.notification.*;
import com.example.notification.sender.*;
import java.util.Map;

public final class DemoApp {
    public static void main(String[] args) {
        NotificationSender email = new EmailSender("smtp.example.com");
        NotificationSender sms = new SmsSender("https://sms-gateway.example.com");
        NotificationSender push = new PushSender(Map.of("key", "value"));

        Notification alertByEmail = new AlertNotification(email);
        Notification reminderBySms = new ReminderNotification(sms);
        Notification promoByPush = new PromotionNotification(push);

        NotificationContext alertContext = new NotificationContext(Map.of(
                "title", "Homework deadline",
                "message", "Don’t forget to submit your assignment on Moodle.",
                "severity", "Due at 23:59"
        ));

        NotificationContext reminderContext = new NotificationContext(Map.of(
                "title", "Project meeting",
                "time", "2025-10-10 14:00",
                "message", "Don't forget to prepare slides."
        ));

        NotificationContext promoContext = new NotificationContext(Map.of(
                "headline", "Flash sale!",
                "offer", "Get 50% off on premium plan.",
                "coupon", "Telegram"
        ));

        alertByEmail.notify("Bek@gmail.com", alertContext);
        reminderBySms.notify("+77001234567", reminderContext);
        promoByPush.notify("Bek", promoContext);
    }
}
