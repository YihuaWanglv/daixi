package com.iyihua.daixi.service.remote;

import java.util.List;

import com.iyihua.daixi.model.Item;


public interface ItemRemote {

	Item getById(Integer id);
	
	void save(Item item, Boolean isUpdateAll);
	
	List<Item> getListByParentId(Integer id);
	
	List<Item> findItemsByParams(Item item);
}
