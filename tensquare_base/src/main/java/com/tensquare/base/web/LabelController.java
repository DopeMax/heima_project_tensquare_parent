package com.tensquare.base.web;

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 标签控制器
 */
@RestController
@RequestMapping("/label")
@CrossOrigin  // 当前的控制器支持跨域访问
public class LabelController {

    @Autowired
    private LabelService labelService;

    /**
     * 查询所有
     *
     * @return
     */
    @GetMapping
    public Result findAll() {
        List<Label> labels = labelService.findAll();
        return new Result(true, StatusCode.OK, "查询成功", labels);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public Result findById(@PathVariable("id") String id) {
        Label label = labelService.findById(id);
        return new Result(true, StatusCode.OK, "查询id成功", label);
    }

    /**
     * 保存
     *
     * @param label
     * @return
     */
    @PostMapping
    public Result save(@RequestBody Label label) {
        labelService.save(label);
        return new Result(true, StatusCode.OK, "保存成功");
    }

    /**
     * 更新
     *
     * @param label
     * @return
     */
    @PutMapping(value = "/{id}")
    public Result update(@PathVariable("id") String id, @RequestBody Label label) {
        label.setId(id);
        labelService.update(label);
        return new Result(true, StatusCode.OK, "更新成功");
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable("id") String id) {
        labelService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /**
     * 条件查询
     *
     * @param label
     * @return
     */
    @PostMapping("/search")
    public Result findSearch(@RequestBody Label label) {
        List<Label> list = labelService.findSearch(label);
        return new Result(true, StatusCode.OK, "查询成功",list);

    }

    /**
     * 条件+分页查询
     *
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}")
    public Result pageQuery(@RequestBody Map searchMap, @PathVariable int page, @PathVariable int size) {
        Page pageList = labelService.pageQuery(searchMap, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Label>(pageList.getTotalElements(), pageList.getContent()));
    }
}
