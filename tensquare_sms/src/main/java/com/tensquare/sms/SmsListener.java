package com.tensquare.sms;

import com.aliyuncs.exceptions.ClientException;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 消息短信监听类
 *
 * @author ChenZiMing
 * @created 2018-12-01-21:50.
 */
//@Component
//@RabbitListener(queues = "sms")
public class SmsListener {

    @Autowired
    private SmsUtil smsUtil;

    @Value("${aliyun.sms.template_code}")
    private String template_code;//模板编号

    @Value("${aliyun.sms.sign_name}")
    private String sign_name;//签名
    /**
     *  发送短信
     * @param map
     */
    //@RabbitHandler
    public void sendSms(Map<String,String> map){
        System.out.println("手机号："+map.get("mobile"));
        System.out.println("验证码："+map.get("checkcode"));

        try {
            smsUtil.sendSms(map.get("mobile"),template_code,sign_name,"{\"number\":\""+map.get("checkcode")+"\"}");
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
