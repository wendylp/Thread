package com.atguigu.b2c.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atguigu.b2c.entities.OBJECT_T_MALL_ATTR;
import com.atguigu.b2c.entities.T_MALL_VALUE;

public interface AttrMapper {

	//注意加@Param注解   有条件判断
	List<OBJECT_T_MALL_ATTR> select_attr_by_class_2_id(@Param("class_2_id") Integer class_2_id);
	

	void insert_attr(OBJECT_T_MALL_ATTR object_T_MALL_ATTR);


	void insert_attr_value(@Param("list_value") List<T_MALL_VALUE> list_value, 
							@Param("attr_id") int id);


}
