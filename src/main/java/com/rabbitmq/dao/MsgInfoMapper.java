package com.rabbitmq.dao;

import com.rabbitmq.entity.MsgInfo;

public interface MsgInfoMapper {

    int insert(MsgInfo record);

    MsgInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MsgInfo record);

}