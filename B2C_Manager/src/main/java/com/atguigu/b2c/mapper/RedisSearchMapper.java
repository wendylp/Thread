package com.atguigu.b2c.mapper;

import java.util.List;
import java.util.Map;

import com.atguigu.b2c.entities.OBJECT_T_MALL_SKU;

public interface RedisSearchMapper {

	List<OBJECT_T_MALL_SKU> select_list_sku_by_class_2_id(Integer class_2_id);

	List<OBJECT_T_MALL_SKU> select_list_sku_by_attr_value(Map<String, Object> map);

	List<Integer> select_list_value_by_attr_id(int attr_id);

}
