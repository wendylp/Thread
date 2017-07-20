package com.atguigu.b2c.service.m;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atguigu.b2c.entities.OBJECT_T_MALL_SKU;
import com.atguigu.b2c.entities.T_MALL_SKU_ATTR_VALUE;
import com.atguigu.b2c.mapper.RedisSearchMapper;
import com.atguigu.b2c.service.i.RedisSearchService;

@Service
public class RedisSearchServiceImpl implements RedisSearchService{

	@Autowired
	private RedisSearchMapper redisSearchMapper;
	
	@Override
	public List<OBJECT_T_MALL_SKU> get_list_sku_by_class_2_id(Integer class_2_id) {
		
		List<OBJECT_T_MALL_SKU> list_sku = redisSearchMapper.select_list_sku_by_class_2_id(class_2_id);
		
		return list_sku;


	}

	@Override
	public List<OBJECT_T_MALL_SKU> get_list_sku_by_attr_value(Integer class_2_id,
			List<T_MALL_SKU_ATTR_VALUE> list_sku_attr_value, String order) {

		Map<String, Object> map = new HashMap<>();
		/*and sku.Id in 
		(
		 select sku_id from 
		(select sku_id from t_mall_sku_attr_value where shxm_id = ? and shxzh_id = ?) sku_1,
		(select sku_id from t_mall_sku_attr_value where shxm_id = ? and shxzh_id = ?) sku_2,
		(select sku_id from t_mall_sku_attr_value where shxm_id = ? and shxzh_id = ?) sku_3
		where sku_1.sku_id = sku_2.sku_id and sku_2.sku_id = sku_3.sku_id
		)*/
		
		StringBuffer buffer = new StringBuffer();
		
			if(list_sku_attr_value != null && list_sku_attr_value.size() > 0){
			
			buffer.append(" and sku.Id in ( select sku_1.sku_id from ");
			
			for(int i = 0; i < list_sku_attr_value.size(); i++){
				
				buffer.append(" (select sku_id from t_mall_sku_attr_value where shxm_id = "+list_sku_attr_value.get(i).getShxm_id()+" and shxzh_id = "+list_sku_attr_value.get(i).getShxzh_id()+") sku_"+(i+1)+" ");
				if(i < (list_sku_attr_value.size() - 1)){
					
					buffer.append(" , ");
				}
				
			}
			
			if(list_sku_attr_value.size() > 1){
				
				buffer.append(" where ");
				for(int i = 0; i < list_sku_attr_value.size(); i++){
					
					if(i < (list_sku_attr_value.size() - 1)){
						
						buffer.append(" sku_"+(i+1)+".sku_id = sku_"+(i+2)+".sku_id ");
						
					}
					
					if(list_sku_attr_value.size() > 2 && i < (list_sku_attr_value.size() - 2)){
						
						buffer.append(" and ");
					}
				}
				
			}
			
			
			buffer.append(" ) ");
		
		}
		
		map.put("class_2_id", class_2_id);
		map.put("sql", buffer);
		map.put("order", order);
		
		List<OBJECT_T_MALL_SKU> list_sku = redisSearchMapper.select_list_sku_by_attr_value(map);
		
		return list_sku;

		
	}

	@Override
	public List<Integer> get_list_value_by_attr_id(int attr_id) {
		
		List<Integer> list_value = redisSearchMapper.select_list_value_by_attr_id(attr_id);
		
		return list_value;
	}
	

}
