package com.atguigu.b2c.mapper;


import java.util.Map;

import com.atguigu.b2c.entities.T_MALL_PRODUCT;

public interface SpuMapper {

	void insert_spu(T_MALL_PRODUCT product);

	void insert_spu_image(Map<String, Object> map);
	

}
