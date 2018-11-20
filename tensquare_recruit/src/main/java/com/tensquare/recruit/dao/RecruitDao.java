package com.tensquare.recruit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.recruit.pojo.Recruit;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface RecruitDao extends JpaRepository<Recruit,String>,JpaSpecificationExecutor<Recruit>{
    /**
     * 根据状态查询职位，时间排序
     * @param state
     * @return
     */
    public List<Recruit> findTop6ByStateOrderByCreatetimeDesc(String state);//where state=? order by recruit

    /**
     * 查询最新职位
     * @param state
     * @return
     */
    public List<Recruit> findTop6ByStateNotOrderByCreatetimeDesc(String state);//where state !=? order by recruit

}
