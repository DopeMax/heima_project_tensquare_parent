package com.tensquare.search.service;

import com.tensquare.search.dao.SpitDao;
import com.tensquare.search.pojo.Spit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.Date;
import java.util.List;

/**
 * @author Chen
 * @created 2018-11-24-15:06.
 */
@Service
@Transactional
public class SpitService {
    @Autowired
    private SpitDao spitDao;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查询全部记录
     *
     * @return
     */
    public List<Spit> findAll() {
        return spitDao.findAll();
    }

    /**
     * 根据主键查询实体
     *
     * @param id
     * @return
     */

    public Spit findById(String id) {
        Spit spit = spitDao.findById(id).get();
        return spit;
    }

    /**
     * 增加
     *
     * @param spit
     */
    public void add(Spit spit) {
       /* //主键值
        search.set_id(idWorker.nextId() + "");
        spitDao.save(search);*/

        spit.set_id(idWorker.nextId() + "");
        spit.setPublishtime(new Date());//发布日期
        spit.setVisits(0);//浏览量
        spit.setShare(0);//分享数
        spit.setThumbup(0);//点赞数
        spit.setComment(0);//回复数
        spit.setState("1");//状态
        //如果存在上级ID,评论
        if (spit.getParentid() != null && !"".equals(spit.getParentid())) {
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(spit.getParentid()));
            Update update = new Update();
            update.inc("comment", 1);
            mongoTemplate.updateFirst(query, update, "search");
        }
        spitDao.save(spit);
    }

    /**
     * 修改
     *
     * @param spit
     */

    public void update(Spit spit) {
        spitDao.save(spit);
    }

    /**
     * 删除
     *
     * @param id
     */

    public void deleteById(String id) {
        spitDao.deleteById(id);
    }

    /**
     * 根据上级ID查询吐槽列表
     *
     * @param parentid
     * @param page
     * @param size
     * @return
     */
    public Page<Spit> findByParentid(String parentid, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return spitDao.findByParentid(parentid, pageRequest);
    }

    /**
     * 点赞
     * @param id
     */
    public void updateThumbup(String id) {
        //方法一：效率问题，每次都要查一下，在插值，访问数据2次。
        /*Spit search = spitDao.findById(id).get();
        search.setThumbup((search.getThumbup() == null ? 0 : search.getThumbup()) + 1);
        spitDao.save(search);*/

        //方法二：使用mongo命令来实现db.search.update({"_id":"1"},{$inc:{thumbup:Number:Int()}})
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Update update = new Update();
        update.inc("thumbup", 1);
        mongoTemplate.updateFirst(query, update, "search");
    }
    /**
     * 增加访问量
     * @param id
     */
    public void addVisit(String id){
        Query query =new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Update update = new Update();
        update.inc("visits",1);
        mongoTemplate.updateFirst(query,update,"search");
    }
    /**
     * 增加分享
     * @param id
     */
    public void addShare(String id){
        Query query =new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Update update = new Update();
        update.inc("share",1);
        mongoTemplate.updateFirst(query,update,"search");
    }
}
