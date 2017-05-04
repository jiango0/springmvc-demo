package com.mongo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.dao.ICommentDao;
import com.mongo.entity.Comment;
import com.mongo.service.ICommentService;

@Service
public class CommentService implements ICommentService {
	
	@Autowired
	ICommentDao commentDao;
	
	public void save(Comment comment){
		commentDao.save(comment);
	}

	public Comment getById(Comment comment) {
		return commentDao.getById(comment);
	}
	
}
