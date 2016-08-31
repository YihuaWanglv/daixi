package com.iyihua.daixi.mapper;

import com.iyihua.daixi.model.UserPoint;

public interface UserPointMapper {
    int deleteByPrimaryKey(Integer upid);

    int insert(UserPoint record);

    int insertSelective(UserPoint record);

    UserPoint selectByPrimaryKey(Integer upid);

    int updateByPrimaryKeySelective(UserPoint record);

    int updateByPrimaryKey(UserPoint record);
}