package com.iyihua.daixi.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.iyihua.daixi.model.UserItem;
@Mapper
public interface UserItemMapper {
    int deleteByPrimaryKey(Integer ilid);

    int insert(UserItem record);

    int insertSelective(UserItem record);

    UserItem selectByPrimaryKey(Integer ilid);

    int updateByPrimaryKeySelective(UserItem record);

    int updateByPrimaryKey(UserItem record);
}