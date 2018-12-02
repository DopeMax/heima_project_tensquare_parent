package com.tensquare.search.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;


/**
 * 吐槽实体
 * @author Chen
 * @created 2018-11-24-15:01.
 */
@Data
public class Spit implements Serializable {
    @Id
    private String _id;
    private String content;
    private Date publishtime;//发布日期
    private String userid;
    private String nickname;
    private Integer visits;//浏览量
    private Integer thumbup;//点赞数
    private Integer share;//分享数
    private Integer comment;//回复数
    private String state;
    private String parentid;
}
