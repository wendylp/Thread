package com.atguigu.b2c.service.i;

import java.util.List;

import com.atguigu.b2c.entities.OBJECT_T_MALL_ATTR;

public interface AttrService {


	List<OBJECT_T_MALL_ATTR> get_attr_by_class_2_id(Integer class_2_id);


	void save_attr(List<OBJECT_T_MALL_ATTR> list_attr, Integer class_2_id);

}
