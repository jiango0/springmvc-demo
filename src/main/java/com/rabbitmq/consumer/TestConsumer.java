package com.rabbitmq.consumer;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.rabbitmq.dao.MsgInfoMapper;
import com.rabbitmq.entity.MsgInfo;
import com.rabbitmq.message.RabbitMessage;

public class TestConsumer {
	
	@Autowired
	MsgInfoMapper msgInfoMapper;
	
	public void execute(Object object){
		RabbitMessage rabbitMessage = (RabbitMessage) object;		
		
		System.out.println(rabbitMessage.getExchange());
        System.out.println(rabbitMessage.getRouteKey());
        System.out.println(rabbitMessage.getParams()[0].toString());
        MsgInfo msgInfo = (MsgInfo) rabbitMessage.getParams()[0];
        msgInfo.setCreateDate(new Date());
        msgInfoMapper.insert(msgInfo);
	}
	
}
