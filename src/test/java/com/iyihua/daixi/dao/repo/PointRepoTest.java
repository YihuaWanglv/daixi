package com.iyihua.daixi.dao.repo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iyihua.daixi.App;
import com.iyihua.daixi.model.Point;
import com.iyihua.daixi.repository.PointRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class PointRepoTest{

	@Autowired PointRepository pointRepository;
	
	@Test
	public void test() {
		
		Point p = new Point();
		p.setIid(1);
		p.setDescription("这是一个题目");
		p.setType(0);
		pointRepository.save(p);
		
//		Point p = pointRepository.findOne(1);
//		System.out.println(p.getDescription());
	}
}
