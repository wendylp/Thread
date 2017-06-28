package com.atguigu.b2c.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.atguigu.b2c.entities.T_MALL_PRODUCT;
import com.atguigu.b2c.service.i.SpuService;
import com.atguigu.b2c.utils.UploadUtils;

@Controller
public class SpuHandler {
	
	@Autowired
	private SpuService spuService;
	
	@RequestMapping("goto_index")
	public String goto_index(String flag, String url, ModelMap map){
		map.put("flag", flag);
		map.put("url", url);
		
		return "/manager_index";
	}
	
	
	@RequestMapping("goto_spu_publish")
	public String goto_spu_publish(String spu){
		
		return "/manager_spu_publish";
	}
	
	
	@RequestMapping("spu_publish")
	public String save_spu(T_MALL_PRODUCT product, @RequestParam("files") MultipartFile[] files){
		
		//商品图片名称集合
		List<String> imageList = UploadUtils.upload(files);
		
		product.setShp_tp(imageList.get(0));
		spuService.save_spu(product, imageList);
		
		//标题名称待定
		return "redirect:/goto_index?flag=@@@&url=goto_spu_publish";
	}

}
