package com.es.common;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.settings.Settings.Builder;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import com.es.utils.EsUtils;

public class EsTools {
	
//	public static Client client = build();
	
	/**
	 *	创建
	 * */
//	private static Client build(){
//		if(null != client){
//			return client;
//		}
//		try{
//			List<String> ips = new ArrayList<>();
//			Builder builder = Settings.settingsBuilder();
//			Map<String, String> map = EsUtils.getProperty();
//			for(Map.Entry<String, String> entry:map.entrySet()){
//				if(entry.getKey() != null){
//					if(entry.getKey().startsWith("es")){
//						builder.put(entry.getKey(), entry.getValue());
//					}else if(entry.getKey().startsWith("ip")){
//						ips.add(entry.getValue());
//					}
//				}
//			}
//			Settings settings = builder.build();
//			TransportClient transport = TransportClient.builder().settings(settings).build();
//			for(String ip : ips){
//				transport.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(ip), 9300));
//			}
//			client = transport;
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		
//		return client;
//	}
	
	/**
	 * 关闭
	 * */
//	public static void close(){
//		if(null != client){
//			try {
//				client.close();
//			} catch (Exception e) {
//				
//			}
//		}
//	}
	
}
