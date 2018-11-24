package com.tensquare.spit.test;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Mongo测试类
 * @author Chen
 * @created 2018-11-24-15:11.
 */
public class MongoTest {
    public static void main(String[] args) {
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
}
