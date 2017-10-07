package com.es.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.client.Client;

import net.sf.json.JSONObject;

public class EsManager {
	
	private static Logger logger = Logger.getLogger(EsManager.class);
	
	public <T> int save(String index, String type, T t){
		List<T> list = new ArrayList<>();
		list.add(t);
		
		return this.save(index, type, list);
	}
	
	public <T> int save(String index, String type, List<T> list){
		Client client = null;
		try{
			client = EsClient.getClient();
			BulkRequestBuilder bulkRequest = client.prepareBulk();
			
			for(T t:list){
				JSONObject jsonObject = JSONObject.fromObject(t);
				String id = jsonObject.getString("id");
				if(StringUtils.isBlank(id)){
					IndexRequestBuilder lrb = client.prepareIndex(index, type).setSource(jsonObject.toString());
					bulkRequest.add(lrb);
				}else{
					IndexRequestBuilder lrb = client.prepareIndex(index, type, id).setSource(jsonObject.toString());
					bulkRequest.add(lrb);
				}
//				bulkRequest.add(client.prepareIndex(index, type).setSource(jsonObject.toString()));
			}
			BulkResponse bulkResponse = bulkRequest.execute().actionGet();
			if(bulkResponse.hasFailures()){
				logger.error("es save fail"+bulkResponse.buildFailureMessage());
				return 0;
			}
		}finally {
			if (client != null){
				client.close();
			}
		}
		
		return 1;
	}
	
}
