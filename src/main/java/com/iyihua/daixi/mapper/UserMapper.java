package com.iyihua.daixi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.iyihua.daixi.model.User;

@Mapper
public interface UserMapper {

	public int updateUserSelective(User user);
	
	public List<String> findRoleNameByUserId(Long userId);
	
}
