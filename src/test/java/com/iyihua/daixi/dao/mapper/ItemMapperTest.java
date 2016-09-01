package com.iyihua.daixi.dao.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iyihua.daixi.App;
import com.iyihua.daixi.mapper.ItemMapper;
import com.iyihua.daixi.model.Item;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class ItemMapperTest {

	@Autowired ItemMapper itemMapper;
	
	@Test
	public void test() {
		Item item = itemMapper.selectByPrimaryKey(1);
		Gson g = new GsonBuilder().serializeNulls().create();
		System.out.println("" + g.toJson(item));
	}
}
