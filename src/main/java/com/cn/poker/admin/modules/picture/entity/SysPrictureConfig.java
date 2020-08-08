package com.cn.poker.admin.modules.picture.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@ConfigurationProperties(prefix="upload")
public class SysPrictureConfig {
	
	 private Map<String, String> uploadMap = new HashMap<>();

	public Map<String, String> getUploadMap() {
		return uploadMap;
	}

	public void setUploadMap(Map<String, String> uploadMap) {
		this.uploadMap = uploadMap;
	}
	 
	 
}
