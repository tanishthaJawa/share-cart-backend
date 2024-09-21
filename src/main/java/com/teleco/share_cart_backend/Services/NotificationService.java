package com.teleco.share_cart_backend.Services;


import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.google.firebase.messaging.FirebaseMessagingException;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendNotification(String token, String title, String body) throws FirebaseMessagingException {

        Notification notification = Notification.builder().setBody(body).setTitle(title).build();
        Message message = Message.builder()
                .setToken(token)
                .setNotification(notification)
                .build();

        String response = FirebaseMessaging.getInstance().send(message);
        System.out.println("Notification sent successfully: " + response);
    }
}
