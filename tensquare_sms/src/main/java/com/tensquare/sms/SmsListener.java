package com.tensquare.sms;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 消息短信监听类
 *
 * @author ChenZiMing
 * @created 2018-12-01-21:50.
 */
@Component
@RabbitListener(queues = "sms")
public class SmsListener {

    /**
     *  发送短信
     * @param message
     */
    @RabbitHandler
    public void sendSms(Map<String,String> message){
        System.out.println("手机号："+message.get("mobile"));
        System.out.println("验证码："+message.get("code"));
    }
}
