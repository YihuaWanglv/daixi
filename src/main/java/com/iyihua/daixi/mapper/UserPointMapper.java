package com.iyihua.daixi.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.iyihua.daixi.model.UserPoint;
@Mapper
public interface UserPointMapper {
    int deleteByPrimaryKey(Integer upid);

    int insert(UserPoint record);

    int insertSelective(UserPoint record);

    UserPoint selectByPrimaryKey(Integer upid);

    int updateByPrimaryKeySelective(UserPoint record);

    int updateByPrimaryKey(UserPoint record);
}