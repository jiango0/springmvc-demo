package com.es.common;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import com.es.utils.EsUtils;

public class EsClient {
	
	private static Settings settings;
	
	private static List<InetSocketTransportAddress> ips;
	
	static {
        init();
    }
	
	/**
	 * 初始化
	 */
	private static void init() {
		Map<String, String> map = EsUtils.getProperty();
	    Settings.Builder settingsBuilder = Settings.builder();
	    ips = new ArrayList<>();
	    String key;
	    String value;
	    for (Map.Entry<String, String> entry : map.entrySet()) {
	        key = entry.getKey();
	        value = entry.getValue();
	        if(StringUtils.isNotBlank(key)){
	        	if(key.startsWith("ip")){
	        		ips.add(getAddress(value));
	        	}else{
	        		settingsBuilder.put(key, value);
	        	}
	        }
	    }
	    settings = settingsBuilder.build();
	}
	
	private static InetSocketTransportAddress getAddress(String address) {
        String host = address.substring(0, address.indexOf(":"));
        int port = Integer.parseInt(address.substring(address.indexOf(":") + 1));
        try {
            return new InetSocketTransportAddress(InetAddress.getByName(host), port);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
	public static Client getClient(){
		PreBuiltTransportClient client = null;
        try {
        	client = new PreBuiltTransportClient(settings);
            for (InetSocketTransportAddress ip : ips) {
            	client.addTransportAddress(ip);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        return client;
	}
	
}
