package com.iyihua.daixi.web.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/item")
public class ItemController {
	
	@Autowired PointRemote pointService;
	@Autowired ItemRemote itemService;
	
	@RequestMapping(value = "/{iid}", method = RequestMethod.GET)
	@ResponseBody
	public JsonObject get(@PathVariable Integer iid) {
		Assert.notNull(iid, "Item id can not be null!");
		Item item = itemService.getById(iid);
		return new JsonObject.Builder(0).data(item).build();
	}
	
	@RequestMapping(value = "/detail/{iid}", method = RequestMethod.GET)
	@ResponseBody
	public JsonObject detail(@PathVariable Integer iid) {
		Assert.notNull(iid, "Item id can not be null!");
		Item item = itemService.getById(iid);
		List<Point> ps = pointService.getListByItemId(iid);
		item.setPoints(ps);
		return new JsonObject.Builder(0).data(item).build();
	}
	
	@RequestMapping(value = "/list/{iid}", method = RequestMethod.GET)
	@ResponseBody
	public JsonObject listItem(@PathVariable Integer iid) {
		if (iid == null) {
			iid = 0;
		}
		List<Item> items = itemService.getListByParentId(iid);
		return new JsonObject.Builder(0).data(items).build();
	}
	
	@RequestMapping(value = "/list/wait", method = RequestMethod.GET)
	@ResponseBody
	public List<Item> listItemWaitting() {
		Item q = new Item();
		q.setStatus(-1);
		List<Item> items = itemService.findItemsByParams(q);
		return items;
	}
}
