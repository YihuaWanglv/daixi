package com.iyihua.daixi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.iyihua.daixi.model.UserPoint;
import com.iyihua.daixi.model.query.PointQuery;
@Mapper
public interface UserPointMapper {
    int deleteByPrimaryKey(Integer upid);

    int insert(UserPoint record);

    int insertSelective(UserPoint record);

    UserPoint selectByPrimaryKey(Integer upid);

    int updateByPrimaryKeySelective(UserPoint record);

    int updateByPrimaryKey(UserPoint record);
    
    List<UserPoint> findUserPoints(PointQuery query);
    
    List<UserPoint> findByParams(UserPoint up);
}