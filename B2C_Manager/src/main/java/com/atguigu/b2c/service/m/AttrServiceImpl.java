package com.atguigu.b2c.service.m;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.b2c.entities.OBJECT_T_MALL_ATTR;
import com.atguigu.b2c.entities.T_MALL_VALUE;
import com.atguigu.b2c.mapper.AttrMapper;
import com.atguigu.b2c.service.i.AttrService;

@Service
public class AttrServiceImpl implements AttrService{

	@Autowired
	private AttrMapper attrMapper;
	
	@Override
	public List<OBJECT_T_MALL_ATTR> get_attr_by_class_2_id(Integer class_2_id) {
		
		List<OBJECT_T_MALL_ATTR> attr_list = attrMapper.select_attr_by_class_2_id(class_2_id);
		
		return attr_list;
	}


	@Override
	public void save_attr(List<OBJECT_T_MALL_ATTR> list_attr, Integer class_2_id) {
		
		
		/*
		 * private int id;
			private String shxm_mch;
			private String shfqy;
			private int flbh2;
			private Date chjshj;
		 * 
		 * 
		 */
		
		
		//立即获取自增主键
		for (OBJECT_T_MALL_ATTR object_T_MALL_ATTR : list_attr) {
			
			object_T_MALL_ATTR.setFlbh2(class_2_id);
			
			attrMapper.insert_attr(object_T_MALL_ATTR);
			
			
			//获取自增的主键
			int id = object_T_MALL_ATTR.getId();
			
			
			
			List<T_MALL_VALUE> list_value = object_T_MALL_ATTR.getList_value();
			
			attrMapper.insert_attr_value(list_value, id);
		
		}
		
	}

}
