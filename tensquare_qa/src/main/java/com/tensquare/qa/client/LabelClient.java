package com.tensquare.qa.client;

import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Chen
 * @created 2018-12-05-21:57.
 */
@FeignClient("tensquare-base")
public interface LabelClient {
    @GetMapping("/label/{id}")
    public Result findById(@PathVariable("id") String id);

}
