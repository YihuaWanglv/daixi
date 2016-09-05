package com.iyihua.daixi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.iyihua.daixi.model.Point;
import com.iyihua.daixi.service.remote.PointRemote;

@Service
public class PointService implements PointRemote {

	@Override
	public Point getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Point point) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Point> getListByItemId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
