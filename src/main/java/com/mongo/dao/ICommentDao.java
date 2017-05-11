package com.mongo.dao;

import com.mongo.common.BaseMongoDAO;
import com.mongo.common.Page;
import com.mongo.entity.Comment;

public interface ICommentDao extends BaseMongoDAO<Comment> {
	
	Comment getById(Comment comment);
	
	Page<Comment> list(Comment comment, Page<Comment> page);
	
}
