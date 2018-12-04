package com.tensquare.user.rabbitmq.test;

import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Chen
 * @created 2018-11-25-15:55.
 */
public class ProductTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void sendMsg(){
        rabbitTemplate.convertAndSend("tentest","直接模式测试");
    }


}
