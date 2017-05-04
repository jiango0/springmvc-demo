/**
 * Copyright (c) 2017-2018 Wuhan Yryz Network Company LTD.
 * All rights reserved.
 * 
 * Created on 2017年4月7日
 * Id: AbsBaseMongoDAO.java, 2017年4月7日 下午2:57:34 yehao
 */
package com.mongo.common;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public abstract class AbsBaseMongoDAO<T>  {
	
    /** 
     * spring mongodb　集成操作类　 
     */
    @Resource(name="mongoTemplate")
    protected MongoTemplate mongoTemplate;
  
    public List<T> find(Query query) {
        return mongoTemplate.find(query, this.getEntityClass());
    }
  
    public T findOne(Query query) {
        return mongoTemplate.findOne(query, this.getEntityClass());
    }
  
    public T update(Query query, Update update) {
        return mongoTemplate.findAndModify(query, update, this.getEntityClass());
    }
  
    public T save(T entity) {
        mongoTemplate.insert(entity);
        return entity;
    }
  
    public T findById(String id) {
        return mongoTemplate.findById(id, this.getEntityClass());
    }
  
    public T findById(String id, String collectionName) {
        return mongoTemplate.findById(id, this.getEntityClass(), collectionName);
    }
      
    public Page<T> findPage(Page<T> page,Query query){
        long count = this.count(query);
        page.setTotalCount(count);
        int pageNumber = page.getPageNo();
        int pageSize = page.getPageSize();
        query.skip((pageNumber - 1) * pageSize).limit(pageSize);
        List<T> rows = this.find(query);
        page.setResultObj(rows);
        return page;
    }
    
    public long count(Query query){
        return mongoTemplate.count(query, this.getEntityClass());
    }
    
    /** 
     * 获取需要操作的实体类class 
     *  
     * @return 
     */  
    private Class<T> getEntityClass(){
        return ReflectionUtils.getSuperClassGenricType(getClass());
    }
  
    /** 
     * 注入mongodbTemplate 
     *  
     * @param mongoTemplate 
     */  
    protected void setMongoTemplate(MongoTemplate mongoTemplate) {
    	this.mongoTemplate = mongoTemplate;
    }

}

