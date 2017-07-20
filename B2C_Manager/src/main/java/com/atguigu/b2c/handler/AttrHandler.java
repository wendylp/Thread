package com.atguigu.b2c.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.b2c.entities.MODEL_OBJECT_T_MALL_ATTR;
import com.atguigu.b2c.entities.OBJECT_T_MALL_ATTR;
import com.atguigu.b2c.service.i.AttrService;

@Controller
public class AttrHandler {
	
	@Autowired
	private AttrService attrService;
	
	@RequestMapping("goto_attr_publish")
	public String goto_attr_publish(){
		
		return "/manager_attr_publish";
	}
	
	
/*	@RequestMapping("get_attr_class_2")
	public String get_attr_class_2(@RequestParam("class_2_id") Integer class_2_id, 
								   @RequestParam("class_2_name") String class_2_name,
									Map<String, Object> map){
		
		List<OBJECT_T_MALL_ATTR> get_attr_list = attrService.get_attr_by_class_2_id(class_2_id);
		
		
		map.put("get_attr_list", get_attr_list);
		map.put("class_2_name", class_2_name);
		
		map.put("class_2_id", class_2_id);
		
		return "/manager_attr_inner";
	}
	*/
	
	@ResponseBody //返回json
	@RequestMapping("get_attr_class_2_json")
	public List<OBJECT_T_MALL_ATTR> get_attr_class_2(@RequestParam("class_2_id") Integer class_2_id, 
								   @RequestParam("class_2_name") String class_2_name,
									HttpSession session){
		
		List<OBJECT_T_MALL_ATTR> get_attr_list = attrService.get_attr_by_class_2_id(class_2_id);
		
		
	/*	map.put("get_attr_list", get_attr_list);
		map.put("class_2_name", class_2_name);
		
		map.put("class_2_id", class_2_id);
		*/
		
		session.setAttribute("class_2_name", class_2_name);
		session.setAttribute("class_2_id", class_2_id);
		
		return get_attr_list;
	}
	
	
	@RequestMapping("attr_add")
	public String attr_add(@RequestParam("class_2_id") Integer class_2_id, 
						   @RequestParam("class_2_name") String class_2_name,
						   Map<String, Object> map){
		
		map.put("class_2_id", class_2_id);
		map.put("class_2_name", class_2_name);
		
		return "/manager_attr_add";
		//return "redirect:/goto_attr_publish";
	}
	
	
	@RequestMapping("save_attr")
	public ModelAndView save_attr(Integer class_2_id, String class_2_name, MODEL_OBJECT_T_MALL_ATTR attr_list){
	
	List<OBJECT_T_MALL_ATTR> list_attr = attr_list.getAttr_list();
	
	attrService.save_attr(list_attr, class_2_id);
	
	String flag = "商品属性发布";
	String url = "goto_attr_publish";
	ModelAndView modelAndView = new ModelAndView("redirect:/goto_index");
	modelAndView.addObject("flag", flag);
	modelAndView.addObject("url", url);
	
	return modelAndView;
		
	}

}
