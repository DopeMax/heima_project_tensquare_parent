package com.tensquare.sms.testMA;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Chen
 * @created 2018-12-03-21:18.
 */

@Component
@RabbitListener(queues = "itcast")
public class CustomerDirect {
    @RabbitHandler
    public void showMessage(String message) {
        System.out.println("itcast接收到消息：" + message);
    }
}
