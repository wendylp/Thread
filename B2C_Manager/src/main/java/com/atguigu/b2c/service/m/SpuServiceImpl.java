package com.atguigu.b2c.service.m;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.b2c.entities.T_MALL_PRODUCT;
import com.atguigu.b2c.mapper.SpuMapper;
import com.atguigu.b2c.service.i.SpuService;

@Service
public class SpuServiceImpl implements SpuService{
	
	@Autowired
	private SpuMapper spuMapper;

	@Override
	public void save_spu(T_MALL_PRODUCT product, List<String> imageList) {
		
		spuMapper.insert_spu(product);
		
		Map<String, Object> map = new HashMap<>();
		map.put("shp_id", product.getId());
		map.put("imageList", imageList);
		
		spuMapper.insert_spu_image(map);
		
	}

}
