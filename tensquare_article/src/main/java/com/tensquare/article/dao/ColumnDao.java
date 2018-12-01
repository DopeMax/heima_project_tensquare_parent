package com.tensquare.article.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.article.pojo.Column;

import java.util.List;

/**
 * 数据访问接口
 *
 * @author Administrator
 */
public interface ColumnDao extends JpaRepository<Column, String>, JpaSpecificationExecutor<Column> {
    /**
     * 根据文章ID查询评论列表
     *
     * @param articleid
     * @return
     */
    public List<Column> findByArticleId(String articleid);
}
