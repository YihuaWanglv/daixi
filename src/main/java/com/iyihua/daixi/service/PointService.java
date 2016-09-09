package com.iyihua.daixi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyihua.daixi.mapper.PointMapper;
import com.iyihua.daixi.model.Point;
import com.iyihua.daixi.service.remote.PointRemote;

@Service
public class PointService implements PointRemote {
	
	@Autowired PointMapper pointMapper;

	@Override
	public Point getById(Integer id) {
		return pointMapper.selectByPrimaryKey(id);
	}

	@Override
	public void save(Point point, Boolean isAllField) {
		if (point.getPid() == null) {
			pointMapper.insertSelective(point);
		} else {
			if (isAllField) {
				pointMapper.updateByPrimaryKey(point);
			} else {
				pointMapper.updateByPrimaryKeySelective(point);
			}
		}
	}

	@Override
	public List<Point> getListByItemId(Integer id) {
		Point q = new Point();
		q.setIid(id);
		return pointMapper.findByParams(q);
	}

}
