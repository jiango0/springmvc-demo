package com.rabbitmqa.listener;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import java.util.Map;

public class EventListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            String data = new String(message.getBody(),"UTF-8");
            Map<String, Object> map = JSONObject.parseObject(data, Map.class);
            System.out.println(map.get("likeCount"));
            System.out.println(map.get("favoriteCount"));
            System.out.println(map.get("shareCount"));
            System.out.println(map.get("commentCount"));
            System.out.println(map.get("viewCount"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

