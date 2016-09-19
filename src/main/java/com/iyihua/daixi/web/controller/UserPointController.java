package com.iyihua.daixi.web.controller;
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
import com.iyihua.daixi.service.remote.PointRemote;
import com.iyihua.daixi.service.remote.UserPointRemote;
import com.iyihua.daixi.web.dto.UserPointView;
import com.iyihua.daixi.web.manager.LoginSessionManager;



@RestController
@RequestMapping("/user/point")
public class UserPointController {
	
	@Autowired PointRemote pointService;
	@Autowired UserPointRemote userPointService;
	@Autowired LoginSessionManager loginSessionManager;
	
	
	@RequestMapping(value = "/{pid}", method = RequestMethod.GET)
	public UserPoint get(@PathVariable Integer pid, Integer upid) {
		
		Long uid = loginSessionManager.getSessionUserId();
		Assert.notNull(uid, "登录失效，请重新登陆");
		
		UserPoint up = null;
		Point p = null;
		
		if (upid != null && upid > 0) {
			up = userPointService.getById(upid);
		}
		if (up == null) {
			p = pointService.getById(pid);
			Assert.notNull(uid, "pid为[" + pid +"]的Point不存在.");
			
			up = new UserPoint();
			BeanUtils.copyProperties(p, up);
			up.setUid(uid);
		}
		return up;
	}
	
	@RequestMapping(value = "/{pid}", method = RequestMethod.PUT)
	public UserPoint answer(@RequestBody UserPoint up, @PathVariable Integer pid) {
		Long uid = loginSessionManager.getSessionUserId();
		Assert.notNull(uid, "登录失效，请重新登陆");
		up.setUid(uid);
//		point.setPid(pid);
		userPointService.save(up, false);
		return up;
	}

}
