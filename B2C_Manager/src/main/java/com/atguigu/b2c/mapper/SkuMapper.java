package com.atguigu.b2c.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.atguigu.b2c.entities.OBJECT_T_MALL_ATTR;
import com.atguigu.b2c.entities.T_MALL_PRODUCT;
import com.atguigu.b2c.entities.T_MALL_SKU;
import com.atguigu.b2c.entities.T_MALL_SKU_ATTR_VALUE;

public interface SkuMapper {

	List<OBJECT_T_MALL_ATTR> select_attr_by_class_2_id(@Param("class_2_id") Integer class_2_id);


	List<T_MALL_PRODUCT> select_spu_list(Map<String, Object> map);


	void insert_sku(T_MALL_SKU sku);

	void insert_sku_attr_value(T_MALL_SKU_ATTR_VALUE sku_attr_value);
}
