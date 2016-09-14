package com.iyihua.daixi.web.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
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
import com.iyihua.daixi.web.dto.ItemView;
import com.iyihua.daixi.web.dto.PointView;



@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired PointRemote pointService;
	@Autowired ItemRemote itemService;
	
	@RequestMapping(value = "/item", method = RequestMethod.GET)
	@ResponseBody
	public List<ItemView> listItem(Integer piid) {
		if (piid == null) {
			piid = 0;
		}
		List<ItemView> ivs = new ArrayList<ItemView>();
		List<Item> items = itemService.getListByParentId(piid);
		for (Item item : items) {
			ItemView iv = new ItemView();
			BeanUtils.copyProperties(item, iv);
			ivs.add(iv);
		}
		return ivs;
	}
	
	@RequestMapping(value = "/item", method = RequestMethod.POST)
	@ResponseBody
	public Item addItem(Item item) {
		
		itemService.save(item, null);
		return item;
	}
	
	@RequestMapping(value = "/item/{iid}", method = RequestMethod.PUT)
	@ResponseBody
	public ItemView updateItem(@RequestBody ItemView item, @PathVariable Integer iid) {
		
		item.setIid(iid);
		
		itemService.save(item, false);
		return item;
	}
	
	@RequestMapping(value = "/point/{iid}", method = RequestMethod.GET)
	@ResponseBody
	public List<PointView> listPoint(@PathVariable Integer iid) {
		List<PointView> pvs = new ArrayList<PointView>();
		List<Point> points = pointService.getListByItemId(iid);
		for (Point p : points) {
			PointView pv = new PointView();
			BeanUtils.copyProperties(p, pv);
			pvs.add(pv);
		}
		return pvs;
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
