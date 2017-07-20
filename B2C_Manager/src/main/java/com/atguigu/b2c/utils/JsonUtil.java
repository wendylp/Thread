package com.atguigu.b2c.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import com.google.gson.Gson;

import net.sf.json.JSONArray;

public class JsonUtil {

	//对象转json
	public static <T> String ObjectToJson(T t) {
		
		Gson gson = new Gson();
		String json = gson.toJson(t);
		
		try {
			json = URLEncoder.encode(json, "utf-8"); //对json字符串进行编码
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return json;
	}

	
	//json转javaBean
	public static <T> T JsonToObject(String value, Class<T> t) {
		
		Gson gson = new Gson();
		T jsonObject = null;
		
		try {
			value = URLDecoder.decode(value, "utf-8");  //解码
			jsonObject = gson.fromJson(value, t);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	
		
		return jsonObject;
	}
	
	
	//json转集合
	public static <T> List<T> jsonToList(String value, Class<T> t){
		
		List<T> jsonList = null;
		
		try {
			if(value != null && value.length() != 0){
				
				
				value = URLDecoder.decode(value, "utf-8");
				
				JSONArray fromObject = JSONArray.fromObject(value);
				
				jsonList = (List<T>) JSONArray.toCollection(fromObject, t);
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return jsonList;
	}

}
