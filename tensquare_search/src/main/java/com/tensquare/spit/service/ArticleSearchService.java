package com.tensquare.spit.service;

import com.tensquare.spit.dao.ArticleSearchDao;
import com.tensquare.spit.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

/**
 * @author Chen
 * @created 2018-11-24-20:07.
 */
@Service
@Transactional
public class ArticleSearchService {
    @Autowired
    private ArticleSearchDao articleSearchDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 增加文章
     *
     * @param article
     */
    public void save(Article article) {
        //article.setId(idWorker.nextId()+"");
        articleSearchDao.save(article);
    }

    public Page<Article> findByTitleLike(String keywords, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return articleSearchDao.findByTitleOrContentLike(keywords, keywords, pageRequest);
    }

}
