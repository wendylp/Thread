package com.atguigu.b2c.handler;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.b2c.entities.MODEL_T_MALL_SKU_ATTR_VALUE;
import com.atguigu.b2c.entities.OBJECT_T_MALL_ATTR;
import com.atguigu.b2c.entities.T_MALL_PRODUCT;
import com.atguigu.b2c.entities.T_MALL_SKU;
import com.atguigu.b2c.service.i.SkuService;


@Controller
public class SkuHandler {
	
	@Autowired
	private SkuService skuService;
	
	@RequestMapping("goto_sku_publish")
	public String go_to_publish(){
		
		return "/manager_sku_publish";
	}
	
	
	
	@RequestMapping("get_sku_class_2")
	public String get_attr_class_2(@RequestParam("class_2_id") Integer class_2_id, 
								   @RequestParam("class_2_name") String class_2_name,
									Map<String, Object> map){
		
		List<OBJECT_T_MALL_ATTR> get_attr_list = skuService.get_attr_by_class_2_id(class_2_id);
		
		
		map.put("get_attr_list", get_attr_list);
		map.put("class_2_name", class_2_name);
		
		map.put("class_2_id", class_2_id);
		
		return "/manager_sku_inner";
	}
	
	@ResponseBody
	@RequestMapping("get_tm")
	public List<T_MALL_PRODUCT> get_spu_list(Integer class_1_id, Integer class_2_id, Integer tm_id){
		
		List<T_MALL_PRODUCT> list_spu = skuService.get_spu_list(class_1_id, class_2_id, tm_id);
		
		return list_spu; //响应数据
	}
	
	
	@RequestMapping("save_sku")
	public ModelAndView save_sku(Integer shp_id, MODEL_T_MALL_SKU_ATTR_VALUE list_sku_attr_value, T_MALL_SKU sku){
		//传参为空会出现异常
		skuService.save_sku(shp_id, list_sku_attr_value, sku);
	
		String flag = "商品sku信息发布";
		String url = "goto_sku_publish";
		
		ModelAndView modelAndView = new ModelAndView("redirect:/goto_index");
		modelAndView.addObject("flag", flag);
		modelAndView.addObject("url", url);
		
		return modelAndView;
		
	}
}
