package com.ozerutkualtun.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Value("${rmq.name.queue}")
    private String queueName;

    @Value("${rmq.name.routing}")
    private String routingName;

    @Value("${rmq.name.exchange}")
    private String exchangeName;


    @Bean
    public Queue queue() {
        return new Queue(queueName);
    }

    @Bean
    public DirectExchange directExchange() { // biz exchange türü olarak direct seçtik. Topic veya fanout seçilebilirdi. detaylı bilgi için resource altındaki fotoya bak.
        return new DirectExchange(exchangeName);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(directExchange()).with(routingName);
    }

}
