package com.iyihua.daixi.web.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iyihua.daixi.model.Item;
import com.iyihua.daixi.model.Point;
import com.iyihua.daixi.model.base.JsonObject;
import com.iyihua.daixi.service.remote.ItemRemote;
import com.iyihua.daixi.service.remote.PointRemote;



@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired PointRemote pointService;
	@Autowired ItemRemote itemService;
	
	@RequestMapping(value = "/item/{iid}", method = RequestMethod.GET)
	@ResponseBody
	public JsonObject listItem(@PathVariable Integer iid) {
		if (iid == null) {
			iid = 0;
		}
		List<Item> items = itemService.getListByParentId(iid);
		return null;
	}
	
	@RequestMapping(value = "/item", method = RequestMethod.POST)
	@ResponseBody
	public JsonObject addPoint(Item item) {
		
		itemService.save(item, null);
		return new JsonObject();
	}
	
	@RequestMapping(value = "/item/{iid}", method = RequestMethod.PUT)
	@ResponseBody
	public JsonObject updatePoint(@RequestBody Item item, @PathVariable Integer iid) {
		
		item.setIid(iid);
		
		itemService.save(item, false);
		return new JsonObject();
	}
	
	@RequestMapping(value = "/point/{iid}", method = RequestMethod.GET)
	@ResponseBody
	public JsonObject listPoint(@PathVariable Integer iid) {
		List<Point> points = pointService.getListByItemId(iid);
		return null;
	}
	
	@RequestMapping(value = "/point", method = RequestMethod.POST)
	@ResponseBody
	public JsonObject addPoint(Point point) {
		
		pointService.save(point, null);
		return new JsonObject();
	}
	
	@RequestMapping(value = "/point/{pid}", method = RequestMethod.PUT)
	@ResponseBody
	public JsonObject updatePoint(@RequestBody Point point, @PathVariable Integer pid) {
		
		point.setPid(pid);
		
		pointService.save(point, false);
		return new JsonObject();
	}

}
