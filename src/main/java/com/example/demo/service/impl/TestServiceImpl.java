package com.example.demo.service.impl;

import com.example.demo.dao.TestDao;
import com.example.demo.entity.GoodsEntity;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestDao testDao;

    @Autowired
    public RedisTemplate redisTemplate;

    @Override
    public List<GoodsEntity> getGoods(String key) {

        boolean hasKey = redisTemplate.hasKey(key);
            if (hasKey){
                List<GoodsEntity> range = redisTemplate.opsForList().range("goods", 0, redisTemplate.opsForList().size("goods"));
                System.out.println("从redis获取");
                return range;
        }else {
            List<GoodsEntity> goodsEntities = testDao.querryGoods();
//            for (GoodsEntity goods:goodsEntities) {
//                redisTemplate.opsForList().leftPush("goods", goods);
//            }
            redisTemplate.opsForList().leftPushAll("goods",goodsEntities);
            return goodsEntities;
        }
    }



}
