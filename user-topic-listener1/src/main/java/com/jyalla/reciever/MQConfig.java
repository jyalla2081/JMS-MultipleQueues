package com.jyalla.reciever;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    // public static final String ROUTING_NAME = "2081-router1";
    // public static final String EXCHANGE_NAME = "2081-topic1";
    // public static final String QUEUE_NAME = "2081-queue1";

    @Autowired
    MQYamlConfig mqYaml;

    // @Bean
    // public Queue queue() {
    // return new Queue(mqYaml.getQueue(), true);
    // }
    //
    // @Bean
    // public TopicExchange exchange() {
    // return new TopicExchange(mqYaml.getExchange());
    // }
    //
    // @Bean
    // public Binding binding(Queue queue, TopicExchange exchange) {
    // return BindingBuilder.bind(queue)
    // .to(exchange)
    // .with(mqYaml.getRouter());
    // }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(converter());
        return template;
    }

}
