package com.test;

import com.es.common.EsManager;
import com.mongo.entity.Comment;

public class TestMain3 {
	
	public static void main(String[] args){
		EsManager es = new EsManager();
		Comment comment = new Comment();
		comment.setCurrentUserName("jiangzhichao");
		comment.setTargetUserName("targetName");
		comment.setContent("dididididididididi");
		comment.setRootId(1L);
		comment.setParentId(0L);
		es.save("test", "comment", comment);
	}
	
}
