package com.example.demo.controller;

import com.example.demo.entity.GoodsEntity;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/test")
    public List<GoodsEntity> result(String key){
        List<GoodsEntity> goodsEntities = testService.getGoods(key);
        return goodsEntities;
    }


}
