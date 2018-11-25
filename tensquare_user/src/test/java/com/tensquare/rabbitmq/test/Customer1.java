package com.tensquare.rabbitmq.test;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Chen
 * @created 2018-11-25-16:03.
 */
@Component
@RabbitListener(queues = "tentest")
public class Customer1 {
    @RabbitHandler
    public void getMsg(String msg) {

        System.out.println("直接模式消费消息的值是：---" + msg + "，当前方法=Customer1.getMsg()");
    }
}
