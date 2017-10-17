package com.rabbitmq.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rabbitmq.entity.MsgInfo;
import com.rabbitmq.message.RabbitMessage;
import com.rabbitmq.producer.TestPorducer;

@Controller
@RequestMapping("rabbit")
public class RabbitMQController {
	
	@Autowired
	TestPorducer testPorducer;
	
	@ResponseBody
	@RequestMapping(value="/send")
	public String send(MsgInfo msgInfo){
		if(msgInfo == null){
			return "msgInfo不能为空";
		}
		RabbitMessage msg = new RabbitMessage("testExchange", "testQueue", "test", msgInfo);
		testPorducer.sendMessage(msg);
		return "1";
	}
	
}
