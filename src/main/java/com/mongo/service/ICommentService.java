package com.mongo.service;

import com.mongo.entity.Comment;

public interface ICommentService {
	
	public void save(Comment comment);
	
	public Comment getById(Comment comment);
	
}
