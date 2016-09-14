package com.iyihua.daixi.web.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iyihua.daixi.model.Point;
import com.iyihua.daixi.model.UserPoint;
import com.iyihua.daixi.model.query.PointQuery;
import com.iyihua.daixi.service.remote.PointRemote;
import com.iyihua.daixi.service.remote.UserPointRemote;
import com.iyihua.daixi.web.dto.UserPointView;
import com.iyihua.daixi.web.manager.LoginSessionManager;



@RestController
@RequestMapping("/point")
public class PointController {
	
	@Autowired PointRemote pointService;
	@Autowired UserPointRemote userPointService;
	@Autowired LoginSessionManager loginSessionManager;
	
	
	@RequestMapping(value = "/{iid}", method = RequestMethod.GET)
	public List<UserPointView> list(@PathVariable Integer iid) {
		List<UserPointView> pvs = new ArrayList<UserPointView>();
//		List<Point> points = pointService.getListByItemId(iid);
		
		Long uid = loginSessionManager.getSessionUserId();
		Assert.notNull(uid, "登录失效，请重新登陆");
		
		PointQuery query = new PointQuery();
		query.setUid(uid);
		query.setIid(iid);
		List<UserPoint> ups = userPointService.findUserPoints(query);
		
		for (UserPoint up : ups) {
			UserPointView pv = new UserPointView();
			BeanUtils.copyProperties(up, pv);
			pvs.add(pv);
		}
		return pvs;
	}

	@RequestMapping(method = RequestMethod.POST)
	public Point create(@RequestBody Point point) {
		pointService.save(point, false);
		return point;
	}
	
	@RequestMapping(value = "/{pid}", method = RequestMethod.PUT)
	public UserPointView answer(@RequestBody UserPointView point, @PathVariable Integer pid) {
		Long uid = loginSessionManager.getSessionUserId();
		Assert.notNull(uid, "登录失效，请重新登陆");
		point.setUid(uid);
//		point.setPid(pid);
		userPointService.save(point, false);
		return point;
	}

	@RequestMapping(value = "/{pid}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long projectId) {
		
	}

}
