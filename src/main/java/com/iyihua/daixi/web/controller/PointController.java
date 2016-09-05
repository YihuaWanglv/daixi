package com.iyihua.daixi.web.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iyihua.daixi.model.Point;
import com.iyihua.daixi.model.base.JsonObject;
import com.iyihua.daixi.service.remote.PointRemote;



@RestController
@RequestMapping("/point")
public class PointController {
	
	@Autowired PointRemote pointService;
	
	@RequestMapping(value = "/list/{iid}", method = RequestMethod.GET)
	@ResponseBody
	public JsonObject listPoint(@PathVariable Integer iid) {
		List<Point> points = pointService.getListByItemId(iid);
		return new JsonObject(points);
	}
	
	@RequestMapping(value = "/{pid}", method = RequestMethod.GET)
	@ResponseBody
	public JsonObject getPoint(@PathVariable Integer pid) {
		Point point = pointService.getById(pid);
		return new JsonObject(point);
	}
	
	@RequestMapping(value = "/{pid}", method = RequestMethod.PUT)
	@ResponseBody
	public JsonObject savePoint(@RequestBody Point point, @PathVariable Integer pid) {
		
		point.setPid(pid);
		
		pointService.save(point);
		return new JsonObject();
	}

}
