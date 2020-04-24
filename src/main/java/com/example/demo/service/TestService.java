package com.example.demo.service;

import com.example.demo.entity.GoodsEntity;

import java.util.List;

public interface TestService {

    public List<GoodsEntity> getGoods(String key);

}
