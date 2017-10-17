package com.rabbitmq.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbitmq.message.RabbitMessage;

@Service
public class TestPorducer {
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	public void sendMessage(RabbitMessage msg) {
		try {
            System.out.println(rabbitTemplate.getConnectionFactory().getHost());
            System.out.println(rabbitTemplate.getConnectionFactory().getPort());
            //发送信息
            rabbitTemplate.convertAndSend(msg.getExchange(), msg.getRouteKey(), msg);
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
	
}
