package com.mongo.dao;

import java.util.List;

import com.mongo.common.BaseMongoDAO;
import com.mongo.entity.Comment;

public interface ICommentDao extends BaseMongoDAO<Comment> {
	
	Comment getById(Comment comment);
	
	List<Comment> list(Comment comment);
	
}
