package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class GoodsEntity implements Serializable {

    private static final long serialVersionUID = -6913587081998766716L;
    private int goodsId;
    private String price;
}
