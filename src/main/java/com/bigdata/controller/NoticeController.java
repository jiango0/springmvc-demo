package com.bigdata.controller;

import com.basis.notice.event.NoticeEvent;
import com.entity.NoticeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "notice")
public class NoticeController {

    @Autowired
    ApplicationContext applicationContext;

    @RequestMapping(value = "get")
    public NoticeInfo get(NoticeInfo noticeInfo) {

        applicationContext.publishEvent(new NoticeEvent(this, noticeInfo));

        return noticeInfo;
    }

}
