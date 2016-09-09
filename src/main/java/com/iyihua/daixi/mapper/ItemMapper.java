package com.iyihua.daixi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.iyihua.daixi.model.Item;
@Mapper
public interface ItemMapper {
    int deleteByPrimaryKey(Integer iid);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Integer iid);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);
    
    List<Item> findItemsByParams(Item record);
}