package com.tensquare.article.pojo;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 文章评论
 *
 * @author ChenZiMing
 * @created 2018-12-01-15:58.
 */
@Data
public class Comment implements Serializable {
    @Id
    private String _id;
    private String articleid;
    private String content;
    private String userid;
    private String parentid;//如果为0表示文章的顶级评论
    private Date publishdate;
}
