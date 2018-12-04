package com.tensquare.spit;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpitApplication.class)//这里的Application是springboot的启动类名
public class SpitApplicationTest {

    /**
     * 测试插入数据
     */
    @Test
    public void MongoDBInsert() {
        MongoClient client = new MongoClient("192.168.1.194");//创建连接
        MongoDatabase spitdb = client.getDatabase("spitdb");//打开数据库
        MongoCollection<Document> spit = spitdb.getCollection("spit");//获取集合
        Map<String, Object> map = new HashMap();
        map.put("content", "我要吐槽");
        map.put("userid", "9999");
        map.put("visits", 123);
        map.put("publishtime", new Date());
        Document document = new Document(map);
        spit.insertOne(document);//插入数据
        client.close();
    }

    /**
     * 测试数据查询
     */
    @Test
    public void MongoDBFindAll() {
        //创建连接
        MongoClient client = new MongoClient("192.168.1.194");
        //创建连接
        MongoDatabase spitdb = client.getDatabase("spitdb");
        //获取集合
        MongoCollection<Document> spit = spitdb.getCollection("spit");
        //查询记录获取文档集合
        FindIterable<Document> documents = spit.find();
        //遍历数据
        for (Document document : documents) { //
            System.out.println("内容：" + document.getString("content"));
            System.out.println("用户ID:" + document.getString("userid"));
            System.out.println("浏览量：" + document.getInteger("visits"));
        }
        //关闭连接
        client.close();
    }

    /**
     * 测试条件查询
     */
    @Test
    public void MongoDBFindBy() {
        //创建连接
        MongoClient client = new MongoClient("192.168.1.194");
        //创建连接
        MongoDatabase spitdb = client.getDatabase("spitdb");
        //获取集合
        MongoCollection<Document> spit = spitdb.getCollection("spit");

       // BasicDBObject bson = new BasicDBObject("visits", new BasicDBObject("$gt", 1000));// 构建查询条件

        BasicDBObject bson = new BasicDBObject("userid", "1013");// 构建查询条件

        //查询记录获取文档集合
        FindIterable<Document> documents = spit.find(bson);
        //遍历数据
        for (Document document : documents) { //
            System.out.println("内容：" + document.getString("content"));
            System.out.println("用户ID:" + document.getString("userid"));
            System.out.println("浏览量：" + document.getInteger("visits"));
        }
        //关闭连接
        client.close();
    }
}

