package com.tensquare.rabbitmq;

import com.tensquare.user.UserApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Chen
 * @created 2018-11-25-15:52.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqTestApplication {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void ProductSendMsg(){
        rabbitTemplate.convertAndSend("tentest","直接模式测试");
    }



}
