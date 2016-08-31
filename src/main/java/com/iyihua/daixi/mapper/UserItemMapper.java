package com.iyihua.daixi.mapper;

import com.iyihua.daixi.model.UserItem;

public interface UserItemMapper {
    int deleteByPrimaryKey(Integer ilid);

    int insert(UserItem record);

    int insertSelective(UserItem record);

    UserItem selectByPrimaryKey(Integer ilid);

    int updateByPrimaryKeySelective(UserItem record);

    int updateByPrimaryKey(UserItem record);
}