package com.iyihua.daixi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.iyihua.daixi.model.Item;
import com.iyihua.daixi.service.remote.ItemRemote;




@Service
public class ItemService implements ItemRemote {

	@Override
	public Item getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Item item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Item> getListByParentId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
