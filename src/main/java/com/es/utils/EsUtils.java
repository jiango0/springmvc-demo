package com.es.utils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class EsUtils {
	
	private static Properties props;
	
	static{
        loadProps();
    }
	
	synchronized static private void loadProps(){
		props = new Properties();
		InputStream in = null;
		try{
			in = EsUtils.class.getClassLoader().getResourceAsStream("es.properties");
			props.load(in);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				if(in != null){
					in.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public static String getProperty(String key){
        if(null == props) {
            loadProps();
        }
        return props.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        if(null == props) {
            loadProps();
        }
        return props.getProperty(key, defaultValue);
    }
    
    public static Map<String, String> getProperty(){
    	if(null == props) {
            loadProps();
        }
    	Map<String, String> map = new HashMap<>();
    	for(Map.Entry<Object, Object> entry : props.entrySet()){
    		String key = String.valueOf(entry.getKey());
            String value = String.valueOf(entry.getValue());
            
            map.put(key, value);
    	}
    	
    	return map;
    }
	
}
