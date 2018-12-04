package com.tensquare.user.jwt;

import com.tensquare.user.UserApplication;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * CreateJwtTest 类,用于生成token
 *
 * @author Chen
 * @created 2018-12-04-19:24.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserApplication.class)
public class CreateJwtTest {

    @Test
    public void CreateJwt() {

        JwtBuilder builder = Jwts.builder();
        builder.setId("888");
        builder.setSubject("小白");

        //设置签发时间
        builder.setIssuedAt(new Date());
        //设置签名秘钥
        builder.signWith(SignatureAlgorithm.HS256, "tensquare");
        System.out.println("秘钥的值是：---" + builder.compact() + "，当前方法=CreateJwtTest.CreateJwt()");

    }

    @Test
    public void CreateJwtExp() {
        //为了方便测试，我们将过期时间设置为1分钟
        long now = System.currentTimeMillis();
        long exp = now + 1000 * 60 * 3;
        JwtBuilder builder = Jwts.builder()
                .setId("888")
                .setSubject("小白")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "tensquare")
                .setExpiration(new Date(exp));
        System.out.println("的值是：---" + builder.compact() + "，当前方法=CreateJwtTest.CreateJwt()");

    }

    @Test
    public void CreateJwtMore() {

        long now = System.currentTimeMillis();
        long exp = now + 1000 * 60 * 3;
        JwtBuilder builder = Jwts.builder()
                .setId("888")
                .setSubject("小白")
                .setIssuedAt(new Date())
                .setExpiration(new Date(exp))
                .signWith(SignatureAlgorithm.HS256, "tensquare")
                .claim("roles", "admin")
                .claim("logo", "logo.png");


        System.out.println("的值是：---" + builder.compact() + "，当前方法=CreateJwtTest.CreateJwt()");
    }
}
