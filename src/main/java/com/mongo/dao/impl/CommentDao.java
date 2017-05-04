package com.mongo.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongo.common.AbsBaseMongoDAO;
import com.mongo.dao.ICommentDao;
import com.mongo.entity.Comment;

@Repository
public class CommentDao extends AbsBaseMongoDAO<Comment> implements ICommentDao  {

	public Comment getById(Comment comment) {
		Query query = new Query();
		query.addCriteria(Criteria.where("rootId").is(comment.getRootId()));
		
		return super.findOne(query);
	}

	public List<Comment> list(Comment comment) {
		if(comment.getRootId() != null){
			
		}
		if(StringUtils.isNotBlank(comment.getCurrentUserName())){
			
		}
		return null;
	}
	
	
	
}
