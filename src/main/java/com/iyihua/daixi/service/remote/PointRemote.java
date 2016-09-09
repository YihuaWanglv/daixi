package com.iyihua.daixi.service.remote;

import java.util.List;

import com.iyihua.daixi.model.Point;

public interface PointRemote {

	Point getById(Integer id);
	
	void save(Point point, Boolean isAllField);
	
	List<Point> getListByItemId(Integer id);
}
