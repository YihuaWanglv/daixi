package com.iyihua.daixi.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.iyihua.daixi.model.Point;

@Mapper
public interface PointMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Point record);

    int insertSelective(Point record);

    Point selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Point record);

    int updateByPrimaryKey(Point record);
}