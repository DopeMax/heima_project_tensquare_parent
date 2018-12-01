package com.tensquare.article.dao;

import com.tensquare.article.pojo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 数据访问接口
 *
 * @author Administrator
 */
public interface CommentDao extends JpaRepository<Comment, String>, JpaSpecificationExecutor<Comment> {
    /**
     * 根据文章ID查询评论列表
     * @param articleid
     * @return
     */
    public List<Comment> findByArticleId(String articleid);
}
