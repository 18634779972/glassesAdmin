package com.xjt.utils;

import java.util.HashMap;
import java.util.Map;

public class BranchPropUtil {
	private String f;
	private static Map<String,String> appMap=new HashMap<String,String>();
	/**
	 * 获取appConfig配置文件中key对应的value值
	 * @param k
	 * @return
	 */
	public static String loadAppConfig(String k){
		String loadpath;
		if(appMap.get(k)==null){
			PropertiesUtil util = new PropertiesUtil("appConfig.properties");
			loadpath = util.readProperty(k);
			appMap.put(k, loadpath);
		}else{
			loadpath=appMap.get(k);
		}
	    return loadpath;
	}
	public static String loadAppConfig(String k,String configName){
		String loadpath;
		PropertiesUtil util = new PropertiesUtil(configName);
		if(appMap.get(k)==null){
			loadpath = util.readProperty(k);
			appMap.put(k, loadpath);
		}else{
			loadpath=appMap.get(k);
		}
	    return loadpath;
	}
	public BranchPropUtil(){}
	public BranchPropUtil(String f){
		this.f = f;
	}
	private String loadprop(String k){
		PropertiesUtil util = new PropertiesUtil(f);
		String loadpath = util.readProperty(k);
	    return loadpath;
	}
}
