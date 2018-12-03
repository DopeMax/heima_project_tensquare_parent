package com.tensquare.sms.testMA;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Chen
 * @created 2018-12-03-21:26.
 */
@Component
@RabbitListener(queues = "kudingyu")
public class CustomerKudingyu {

    @RabbitHandler
    public void showMessage(String message){
        System.out.println("kudingyu的值是：---" + message + "，当前方法=CustomerKudingyu.showMessage()");
    }
}
