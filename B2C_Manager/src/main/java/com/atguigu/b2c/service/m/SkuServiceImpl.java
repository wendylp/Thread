package com.atguigu.b2c.service.m;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.b2c.entities.MODEL_T_MALL_SKU_ATTR_VALUE;
import com.atguigu.b2c.entities.OBJECT_T_MALL_ATTR;
import com.atguigu.b2c.entities.T_MALL_PRODUCT;
import com.atguigu.b2c.entities.T_MALL_SKU;
import com.atguigu.b2c.entities.T_MALL_SKU_ATTR_VALUE;
import com.atguigu.b2c.mapper.SkuMapper;
import com.atguigu.b2c.service.i.SkuService;

@Service 
public class SkuServiceImpl implements SkuService{

	@Autowired
	private SkuMapper skuMapper;
	@Override
	public List<OBJECT_T_MALL_ATTR> get_attr_by_class_2_id(Integer class_2_id) {
	
		List<OBJECT_T_MALL_ATTR> attr_list = skuMapper.select_attr_by_class_2_id(class_2_id);
		return attr_list;
	}
	
	


	@Override
	public List<T_MALL_PRODUCT> get_spu_list(Integer class_1_id, Integer class_2_id, Integer tm_id) {
		//利用Map封装参数
		Map<String, Object> map = new HashMap<>();
		map.put("flbh1", class_1_id);
		map.put("flbh2", class_2_id);
		map.put("pp_id", tm_id);
		
		List<T_MALL_PRODUCT> spu_list = skuMapper.select_spu_list(map);
				
		return spu_list;
	}




	@Override
	public void save_sku(Integer shp_id, MODEL_T_MALL_SKU_ATTR_VALUE list_sku_attr_value, T_MALL_SKU sku) {
		
		/*
		 * 	private int id;
			private int shxm_id;
			private int shxzh_id;
			private int shp_id;
			private String is_sku;
			private Date chjshj;
			private int sku_id;
			
		 * 
		 * 
		 */

		sku.setShp_id(shp_id);
		skuMapper.insert_sku(sku);
		int sku_id = sku.getId();
		
		
		List<T_MALL_SKU_ATTR_VALUE> sku_attr_value_list = list_sku_attr_value.getList_sku_attr_value();
		
		for (T_MALL_SKU_ATTR_VALUE sku_attr_value : sku_attr_value_list) {
			
			sku_attr_value.setSku_id(sku_id);
			sku_attr_value.setShp_id(shp_id);
			
			skuMapper.insert_sku_attr_value(sku_attr_value);
			
		}
		
	}



}
