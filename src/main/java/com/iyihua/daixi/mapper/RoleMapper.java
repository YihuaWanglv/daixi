package com.iyihua.daixi.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.iyihua.daixi.model.Role;
@Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}