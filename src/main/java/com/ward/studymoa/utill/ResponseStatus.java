package com.ward.studymoa.utill;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**************************************************
* @FileName : ResponseStatus.java
* @Description: RESTFUL API 응답 반환 셋 
* @Author : DK. Kang
* @Version : 2019. 7. 20.
* @Copyright : ⓒlifesemantics. All Right Reserved
**************************************************/
public enum ResponseStatus {
	
	SUCCESS(1000, "Success"),
	
	DUPLICATION(1110, "Duplication"),
	
	FAILURE(1990, "Failure"),
	
	NULL_EXCEPTION(9190, "Null Exception"),
	INVALID_INPUT(9391, "Invalid Input"),
	EXCEPTION(9990, "Exception")
	;
	
	private final int code;
	private final String message;
	
	private ResponseStatus(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	
	public Map<String, Object> toMap() {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("code", code);
		map.put("message", message);
		return map;
	}
	
	public Map<String, Map<String, Object>> toRemap() {
		Map<String, Map<String, Object>> remap = new HashMap<String, Map<String, Object>>();
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("code", code);
		map.put("message", message);
		remap.put("responseStatus", map);
		return remap;
	}
	
	public Map<String, Map<String, Object>> toRemap(int count) {
		Map<String, Map<String, Object>> remap = new HashMap<String, Map<String, Object>>();
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("code", code);
		map.put("message", message);
		map.put("count", count);
		remap.put("responseStatus", map);
		return remap;
	}
	
	public Map<String, Object> toInmap(String key, Object value) {
		Map<String, Object> inmap = new LinkedHashMap<String, Object>();
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("code", code);
		map.put("message", message);
		inmap.put("responseStatus", map);
		inmap.put(key, value);
		return inmap;
	}
	
	public Map<String, Object> toMessage(String key, Object value) {
		Map<String, Object> inmap = new LinkedHashMap<String, Object>();
		inmap.put("cid", key);
		inmap.put("result", value);
		return inmap;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"code\":").append(code).append(", ");
		sb.append("\"message\":").append(message);
		sb.append("}");
		return sb.toString();
	}
	
}