package com.rabbitmqa.send;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.UUID;

@Component
public class EventSend {

    @Autowired
    private RabbitTemplate directTemplate;

    public void send(String queue, Map<String, Object> data){
        MessageProperties messageProperties = MessagePropertiesBuilder.newInstance()
                .setCorrelationId(UUID.randomUUID().toString().getBytes())
                .build();

        String body = JSONObject.toJSONString(data);
        try {
            Message message = MessageBuilder.withBody(body.getBytes("UTF-8"))
                    .andProperties(messageProperties).build();
            directTemplate.send(queue, message);
        } catch (UnsupportedEncodingException e) {
        }
    }

}
