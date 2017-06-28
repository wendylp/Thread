package com.atguigu.b2c.service.i;

import java.util.List;

import com.atguigu.b2c.entities.T_MALL_PRODUCT;

public interface SpuService {

	void save_spu(T_MALL_PRODUCT product, List<String> imageList);

}
