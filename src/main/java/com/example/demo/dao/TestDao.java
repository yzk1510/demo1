package com.example.demo.dao;

import com.example.demo.entity.GoodsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value ="TestDao")
public interface TestDao {

    @Select("select * from goods")
    List<GoodsEntity> querryGoods();
}
