package com.atguigu.b2c.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.atguigu.b2c.entities.OBJECT_T_MALL_SKU;
import com.atguigu.b2c.entities.T_MALL_SKU_ATTR_VALUE;
import com.atguigu.b2c.service.i.RedisSearchService;
import com.atguigu.b2c.utils.JedisUtil;


@Controller
public class RedisSearchHandler {

	@Autowired
	private RedisSearchService redisSearchService;
	
	@RequestMapping("goto_search_redis")
	public String goto_redis_search(){
		
		
		return "/redis_search";
	}
	
	
	@RequestMapping("redis_search_class_2")
	@ResponseBody
	public int redis_search_class_2(Integer class_2_id){
		
		//根据二级分类id查出对应的sku集合
		List<OBJECT_T_MALL_SKU> list_sku = redisSearchService.get_list_sku_by_class_2_id(class_2_id);
		
		JedisUtil.put_redis(class_2_id + "", list_sku);
		
		return list_sku.size();
	}
	
	
	@RequestMapping("redis_search_attr_value")
	@ResponseBody
	public long redis_search_attr_value(int class_2_id, @RequestParam("attr_array[]") int[] attr_array){
		
		long count = 0L;
		//根据属性id查出属性值id集合
		for(int i = 0; i < attr_array.length; i++){
			int attr_id = attr_array[i];
			
			/**
			 * 根据属性id查属性值id集合
			 */
			List<Integer> list_value = redisSearchService.get_list_value_by_attr_id(attr_id);
			
			for (int j = 0; j < list_value.size(); j++) {
				List<T_MALL_SKU_ATTR_VALUE> list_sku_attr_value = new ArrayList<>();
				T_MALL_SKU_ATTR_VALUE sku_attr_value = new T_MALL_SKU_ATTR_VALUE();
				
				sku_attr_value.setShxm_id(attr_id);
				sku_attr_value.setShxzh_id(list_value.get(j));
				
				list_sku_attr_value.add(sku_attr_value);
				
				List<OBJECT_T_MALL_SKU> list_sku = redisSearchService.get_list_sku_by_attr_value(class_2_id, list_sku_attr_value, "");
				
				String key = class_2_id + "_" + attr_id + "_" + list_value.get(j);
				//循环sku集合转化为json字符串放入redis中
				
				JedisUtil.put_redis(key, list_sku);
				
				count++;
			}
		}
		
		return count;
	}
}
