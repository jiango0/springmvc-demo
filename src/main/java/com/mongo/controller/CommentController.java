package com.mongo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongo.entity.Comment;
import com.mongo.service.ICommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private ICommentService commentService;
	
	@ResponseBody
	@RequestMapping(value="/save")
	public void save(@RequestBody Comment comment){
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "key1");
		map.put("key2", "key1");
		map.put("key3", "key1");
		map.put("key4", "key1");
		list.add(map);
		list.add(map);
		list.add(map);
		list.add(map);
		comment.setDetailList(list);

		commentService.save(comment);
	}
	
	@ResponseBody
	@RequestMapping(value="/getById")
	public Comment getById(@RequestBody Comment comment){
		return commentService.getById(comment);
	}
	
}
