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
@SpringBootTest(classes = UserApplication.class)
public class RabbitmqTestApplication {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void ProductSendMsg() {
        rabbitTemplate.convertAndSend("tentest", "直接模式测试");
    }

    @Test
    public void testSendDirect() {
        rabbitTemplate.convertAndSend("itcast", "直接模式测试");
    }
    @Test
    public void testSendFanout(){
        rabbitTemplate.convertAndSend("chuanzhi","", "分列模式走起");
    }
    @Test
    public void testSendTopic1(){
        rabbitTemplate.convertAndSend("topictest","goods.aaa", "主题模式");
    }
    @Test
    public void testSendTopic2(){
        rabbitTemplate.convertAndSend("topictest","article.content.log", "主题模式");
    }
    @Test
    public void testSendTopic3(){
        rabbitTemplate.convertAndSend("topictest","goods.log", "主题模式");
    }
}
