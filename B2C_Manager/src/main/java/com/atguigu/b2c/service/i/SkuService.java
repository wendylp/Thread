package com.atguigu.b2c.service.i;

import java.util.List;

import com.atguigu.b2c.entities.MODEL_T_MALL_SKU_ATTR_VALUE;
import com.atguigu.b2c.entities.OBJECT_T_MALL_ATTR;
import com.atguigu.b2c.entities.T_MALL_PRODUCT;
import com.atguigu.b2c.entities.T_MALL_SKU;

public interface SkuService {

	List<OBJECT_T_MALL_ATTR> get_attr_by_class_2_id(Integer class_2_id);


	List<T_MALL_PRODUCT> get_spu_list(Integer class_1_id, Integer class_2_id, Integer tm_id);


	void save_sku(Integer shp_id, MODEL_T_MALL_SKU_ATTR_VALUE list_sku_attr_value, T_MALL_SKU sku);

}
