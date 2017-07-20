package com.atguigu.redis;


import org.junit.Test;

import com.atguigu.b2c.utils.JedisPoolUtil;

import redis.clients.jedis.Jedis;

public class TestJedis {

	@Test
	public void testRedis() {
		
		Jedis jedis = new Jedis("192.168.37.128", 6379);
		
		String ping = jedis.ping();
		System.out.println(ping);
		
		
		jedis.set("k1", "value1");
		String value01 = jedis.get("k1");
		System.out.println(value01);
		
	}
	
	@Test
	public void testJedisPool(){
		
		Jedis jedis = JedisPoolUtil.getJedis();
		String ping = jedis.ping();
		
		System.out.println(ping);
		
	}

}
