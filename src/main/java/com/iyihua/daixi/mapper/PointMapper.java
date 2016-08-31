package com.iyihua.daixi.mapper;

import com.iyihua.daixi.model.Point;

public interface PointMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Point record);

    int insertSelective(Point record);

    Point selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Point record);

    int updateByPrimaryKey(Point record);
}