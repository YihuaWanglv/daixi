package com.iyihua.daixi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyihua.daixi.mapper.UserPointMapper;
import com.iyihua.daixi.model.UserPoint;
import com.iyihua.daixi.model.query.PointQuery;
import com.iyihua.daixi.service.remote.UserPointRemote;

@Service
public class UserPointService implements UserPointRemote {
	
	@Autowired UserPointMapper userPointMapper;
//	@Autowired UserPointRepository userPointRepository;

	@Override
	public List<UserPoint> getListByUserId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserPoint> getListByUserAndPoint(Integer userId, Integer pointId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserPoint save(UserPoint up, Boolean isAllField) {
		if (up.getUpid() == null) {
			if (isAllField) {
				userPointMapper.insert(up);
			} else {
				userPointMapper.insertSelective(up);
			}
		} else {
			if (isAllField) {
				userPointMapper.updateByPrimaryKey(up);
			} else {
				userPointMapper.updateByPrimaryKeySelective(up);
			}
		}
		return up;
	}

	@Override
	public UserPoint getById(Integer id) {
		return userPointMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<UserPoint> findUserPoints(PointQuery query) {
		return userPointMapper.findUserPoints(query);
	}

	@Override
	public List<UserPoint> findByParams(UserPoint up) {
		return userPointMapper.findByParams(up);
	}

	@Override
	public UserPoint getUserPointByIidAndUid(Integer pid, Long uid) {
		UserPoint up = new UserPoint();
		up.setPid(pid);
		up.setUid(uid);
		List<UserPoint> userPoints = userPointMapper.findByParams(up);
		if (userPoints != null && userPoints.size() > 0) {
			if (userPoints.size() > 1) {
				throw new RuntimeException("pid[" +pid+"],uid["+uid+"]的数据多余1条，数据异常.");
			}
			return userPoints.get(0);
		}
		return null;
	}

}
