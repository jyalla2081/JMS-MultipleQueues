package com.jyalla.reciever;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class MessageListner {
    private static Logger logger = LoggerFactory.getLogger(MessageListner.class);

    @RabbitListener(queues = "2081-queue2")
    public void listner(CustomMessage message) {
        logger.info("Recieved MEssage is: " + message);
    }
}
