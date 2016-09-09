package com.iyihua.daixi.web.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iyihua.daixi.model.Point;
import com.iyihua.daixi.service.remote.PointRemote;
import com.iyihua.daixi.web.dto.PointView;



@RestController
@RequestMapping("/point")
public class PointController {
	
	@Autowired PointRemote pointService;
	
//	@RequestMapping(value = "/list/{iid}", method = RequestMethod.GET)
//	@ResponseBody
//	public JsonObject listPoint(@PathVariable Integer iid) {
//		List<Point> points = pointService.getListByItemId(iid);
//		return null;
//	}
//	
//	@RequestMapping(value = "/{pid}", method = RequestMethod.GET)
//	@ResponseBody
//	public JsonObject getPoint(@PathVariable Integer pid) {
//		Point point = pointService.getById(pid);
//		return null;
//	}
//	
//	@RequestMapping(value = "/{pid}", method = RequestMethod.PUT)
//	@ResponseBody
//	public JsonObject savePoint(@RequestBody Point point, @PathVariable Integer pid) {
//		
//		point.setPid(pid);
//		
//		pointService.save(point, false);
//		return new JsonObject();
//	}
	
	@RequestMapping(value = "/{iid}", method = RequestMethod.GET)
	public List<PointView> list(@PathVariable Integer iid) {
		List<PointView> pvs = new ArrayList<PointView>();
		List<Point> points = pointService.getListByItemId(iid);
		for (Point point : points) {
			PointView pv = new PointView();
			BeanUtils.copyProperties(point, pv);
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
	public PointView update(@RequestBody PointView point, @PathVariable Integer pid) {
		point.setPid(pid);
		pointService.save(point, false);
		return point;
	}

	@RequestMapping(value = "/{pid}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long projectId) {
		
	}

}
