package com.iyihua.daixi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyihua.daixi.mapper.ItemMapper;
import com.iyihua.daixi.model.Item;
import com.iyihua.daixi.service.remote.ItemRemote;




@Service
public class ItemService implements ItemRemote {

	@Autowired ItemMapper itemMapper;
	
	@Override
	public Item getById(Integer id) {
		return itemMapper.selectByPrimaryKey(id);
	}

	@Override
	public void save(Item item, Boolean isUpdateAll) {
		if (item.getIid() == null) {
			itemMapper.insert(item);
		} else {
			if (isUpdateAll) {
				itemMapper.updateByPrimaryKey(item);				
			} else {
				itemMapper.updateByPrimaryKeySelective(item);
			}
		}
	}

	@Override
	public List<Item> getListByParentId(Integer id) {
		Item query = new Item();
		query.setPiid(id);
		return itemMapper.findItemsByParams(query);
	}

	@Override
	public List<Item> findItemsByParams(Item item) {
		return itemMapper.findItemsByParams(item);
	}

}
