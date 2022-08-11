package com.ozerutkualtun.rabbitmq.listener;

import com.ozerutkualtun.rabbitmq.model.NotificationMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationMessageListener {

    @RabbitListener(queues = "sample-queue")
    public void handleMessage(NotificationMessage notificationMessage) {
        System.out.println("MESSAGE RECEIVED");
        System.out.println(notificationMessage);
    }

}
