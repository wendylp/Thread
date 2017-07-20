package com.atguigu.b2c.service.i;

import java.util.List;

import com.atguigu.b2c.entities.OBJECT_T_MALL_SKU;
import com.atguigu.b2c.entities.T_MALL_SKU_ATTR_VALUE;

public interface RedisSearchService {

	List<OBJECT_T_MALL_SKU> get_list_sku_by_class_2_id(Integer class_2_id);

	List<OBJECT_T_MALL_SKU> get_list_sku_by_attr_value(Integer class_2_id, List<T_MALL_SKU_ATTR_VALUE> list_sku_attr_value, String order);

	List<Integer> get_list_value_by_attr_id(int attr_id);
}
