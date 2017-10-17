package com.rabbitmq.entity;

import java.io.Serializable;
import java.util.Date;

public class MsgInfo implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 9125725924179721015L;

	private Long id;

    private String title;

    private Integer code;

    private Date createDate;

    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}