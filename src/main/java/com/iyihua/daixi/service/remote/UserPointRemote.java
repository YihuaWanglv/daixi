package com.iyihua.daixi.service.remote;

import java.util.List;

import com.iyihua.daixi.model.UserPoint;

public interface UserPointRemote {

	List<UserPoint> getListByUserId(Integer id);
	
	List<UserPoint> getListByUserAndPoint(Integer userId, Integer pointId);
	
	void save(UserPoint up);
	
	UserPoint getById(Integer id);
}
