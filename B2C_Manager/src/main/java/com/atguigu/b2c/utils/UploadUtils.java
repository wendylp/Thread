package com.atguigu.b2c.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.web.multipart.MultipartFile;

public class UploadUtils {
	
	public static List<String> upload(MultipartFile[] files){
		
		String basePath = getPathResource("windows_path");
		List<String> imageList = new ArrayList<>();
		
		for (int i = 0; i < files.length; i++) {
			String imageName = System.currentTimeMillis() + files[i].getOriginalFilename();
			
			imageList.add(imageName); //
			String imagePath = basePath + "\\" + imageName;
			
			//图片转存
			try {
				files[i].transferTo(new File(imagePath));
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
		
		return imageList;
	}
	
	public static String getPathResource(String key){
		
		Properties properties = new Properties();
		
		InputStream resource = UploadUtils.class.getClassLoader().getResourceAsStream("pathResource.properties");
		try {
			properties.load(resource);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String imagePath = properties.getProperty(key);
		
		return imagePath;
	}

}
