package com.iyihua.daixi.service.remote;

import java.util.List;

import com.iyihua.daixi.model.UserPoint;
import com.iyihua.daixi.model.query.PointQuery;

public interface UserPointRemote {

	List<UserPoint> getListByUserId(Integer id);
	
	List<UserPoint> getListByUserAndPoint(Integer userId, Integer pointId);
	
	UserPoint save(UserPoint up, Boolean isAllField);
	
	UserPoint getById(Integer id);
	
	List<UserPoint> findUserPoints(PointQuery query);
	
	List<UserPoint> findByParams(UserPoint up);
	
	UserPoint getUserPointByIidAndUid(Integer pid, Long uid);
}
