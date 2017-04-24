package com.bigdata.entity;

import java.util.Date;

public class UserInfo {
    private Integer userId;

    private String userName;

    private String userNo;

    private String password;

    private Integer status;

    private Integer createId;

    private Date createTime;

    private Integer modefileId;

    private Date modefileTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getModefileId() {
        return modefileId;
    }

    public void setModefileId(Integer modefileId) {
        this.modefileId = modefileId;
    }

    public Date getModefileTime() {
        return modefileTime;
    }

    public void setModefileTime(Date modefileTime) {
        this.modefileTime = modefileTime;
    }
}