package com.ozerutkualtun.rabbitmq.producer;

import com.ozerutkualtun.rabbitmq.model.NotificationMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificationMessageProducer {

    @Value("${rmq.name.routing}")
    private String routingName;

    @Value("${rmq.name.exchange}")
    private String exchangeName;

    private final RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        sendToQueue(
                NotificationMessage.builder()
                        .id(UUID.randomUUID().toString())
                        .createdAt(new Date(System.currentTimeMillis()))
                        .seen(Boolean.FALSE)
                        .message("Sample message")
                        .build()
        );
    }

    public void sendToQueue(NotificationMessage notificationMessage) {

        rabbitTemplate.convertAndSend( exchangeName ,routingName, notificationMessage);
    }


}
