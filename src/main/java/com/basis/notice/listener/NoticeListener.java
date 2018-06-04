package com.basis.notice.listener;

import com.alibaba.fastjson.JSON;
import com.basis.notice.event.NoticeEvent;
import com.entity.NoticeInfo;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class NoticeListener implements ApplicationListener<NoticeEvent> {

    @Override
    public void onApplicationEvent(NoticeEvent noticeEvent) {
        NoticeInfo noticeInfo = noticeEvent.getNoticeInfo();
        System.out.println(JSON.toJSONString(noticeInfo));
    }

}
