package com.rabbitmqa.web;

import com.rabbitmqa.send.EventSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("event")
public class EventController {

    @Autowired
    EventSend eventSend;

    @ResponseBody
    @RequestMapping(value="send")
    public String eventSend(Integer likeCount, Integer favoriteCount, Integer shareCount, Integer commentCount, Integer viewCount){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("likeCount", likeCount);
        map.put("favoriteCount", favoriteCount);
        map.put("shareCount", shareCount);
        map.put("commentCount", commentCount);
        map.put("viewCount", viewCount);

        eventSend.send("event.queue", map);

        return "1";
    }

    @ResponseBody
    @RequestMapping(value="hello")
    public String hello(){
        return "helloWorld";
    }

}
