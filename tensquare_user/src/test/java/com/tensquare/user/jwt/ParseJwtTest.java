package com.tensquare.user.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.junit.Test;

import java.text.SimpleDateFormat;

/**
 * 解析token
 *
 * @author Chen
 * @created 2018-12-04-19:39.
 */
public class ParseJwtTest {


    public static void main(String[] args) {

        //parseJwt();
        //parseJwtExp();
        parseJwtMore();

    }


    public static void parseJwt() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiLlsI_nmb0iLCJpYXQiOjE1NDM5MjM1NDh9.2P32wRYK9f_K1jvc3evyiFG6BfnVEHghZOUtje6Cf-A";
        Claims claims = Jwts.parser().setSigningKey("tensquare").parseClaimsJws(token).getBody();
        System.out.println("id的值是：---" + claims.getId() + "，当前方法=ParseJwtTest.main()");
        System.out.println("subject的值是：---" + claims.getSubject() + "，当前方法=ParseJwtTest.main()");
        System.out.println("IssuedAt的值是：---" + claims.getIssuedAt() + "，当前方法=ParseJwtTest.main()");

    }

    public static void parseJwtExp() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiLlsI_nmb0iLCJpYXQiOjE1NDM5MjQwNzcsImV4cCI6MTU0MzkyNDEzN30.gxovB7108ZR5Wnf9rcUv2sahUQ7JwAUtpFPvaxpgcoE";
        Claims claims = Jwts.parser().setSigningKey("tensquare").parseClaimsJws(token).getBody();

        System.out.println("id的值是：---" + claims.getId() + "，当前方法=ParseJwtTest.main()");

        System.out.println("subject的值是：---" + claims.getSubject() + "，当前方法=ParseJwtTest.main()");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("签发时间：---" + sdf.format(claims.getIssuedAt()));
        System.out.println("过期时间：---" + sdf.format(claims.getExpiration()));
    }


    public static void parseJwtMore() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiLlsI_nmb0iLCJpYXQiOjE1NDM5MjUxNDgsImV4cCI6MTU0MzkyNTMyOCwicm9sZSI6ImFkbWluIiwibG9nbyI6ImxvZ28ucG5nIn0.cA-e87sOFKa77riJCB4vdYgZVJXqs5ePP659J-NA2mg";
        Claims claims = Jwts.parser().setSigningKey("tensquare").parseClaimsJws(token).getBody();

        System.out.println("id的值是：---" + claims.getId() + "，当前方法=ParseJwtTest.main()");
        System.out.println("subject的值是：---" + claims.getSubject() + "，当前方法=ParseJwtTest.main()");
        System.out.println("roles的值是：---" + claims.get("roles") + "，当前方法=ParseJwtTest.main()");
        System.out.println("logot的值是：---" + claims.get("logo") + "，当前方法=ParseJwtTest.main()");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("签发时间：---" + sdf.format(claims.getIssuedAt()));
        System.out.println("过期时间：---" + sdf.format(claims.getExpiration()));
    }
}
