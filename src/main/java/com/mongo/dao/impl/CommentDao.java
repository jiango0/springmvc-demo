package com.mongo.dao.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongo.common.AbsBaseMongoDAO;
import com.mongo.common.Page;
import com.mongo.dao.ICommentDao;
import com.mongo.entity.Comment;

@Repository
public class CommentDao extends AbsBaseMongoDAO<Comment> implements ICommentDao  {

	public Comment getById(Comment comment) {
		Query query = new Query();
		query.addCriteria(Criteria.where("rootId").is(comment.getRootId()));
		
		return super.findOne(query);
	}

	public Page<Comment> list(Comment comment, Page<Comment> page) {
		if(comment == null){
			return null;
		}
		if(page != null && page.getPageSize() == 0){
			page.setPageSize(20);
		}
		if(page != null && page.getPageNo() == 0){
			page.setPageNo(1);
		}
		Query query = new Query();
		if(comment.getRootId() != null){
			query.addCriteria(Criteria.where("rootId").is(comment.getRootId()));
		}
		if(StringUtils.isNotBlank(comment.getCurrentUserName())){
			// ^正则规则
			query.addCriteria(Criteria.where("currentUserName").regex("^"+comment.getCurrentUserName(), "i"));
		}
		
		return findPage(page, query);
	}
	
	
	
}
