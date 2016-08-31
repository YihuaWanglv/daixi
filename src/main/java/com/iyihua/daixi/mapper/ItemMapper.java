package com.iyihua.daixi.mapper;

import com.iyihua.daixi.model.Item;

public interface ItemMapper {
    int deleteByPrimaryKey(Integer iid);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Integer iid);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);
}