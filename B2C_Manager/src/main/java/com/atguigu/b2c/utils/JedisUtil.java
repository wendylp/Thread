package com.atguigu.b2c.utils;

import java.util.List;
import redis.clients.jedis.Jedis;

public class JedisUtil {

	/**
	 * 
	 * 
	 * 把根据二级分类id查出的结果放入到redis中
	 * @param class_2_id
	 * @param t
	 */
	public static <T> void put_redis(String number, List<T> t){
		
		Jedis jedis = JedisPoolUtil.getJedis();
		
		String key = "key_2_" + number;
		//每次书刷新删除以前的key
		jedis.del(key);
		
		if(t != null && t.size() != 0){
			
			for (int i = 0; i < t.size(); i++) {
				
				String json = JsonUtil.ObjectToJson(t.get(i));
				
				jedis.zadd(key, i, json);
			}
			
		}
	}
}
