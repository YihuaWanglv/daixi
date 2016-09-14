package com.iyihua.daixi.web.dto;

import com.iyihua.daixi.model.Item;

public class ItemView extends Item {

	private static final long serialVersionUID = 4737721570901262949L;
	
	private boolean editting = false;

	public boolean isEditting() {
		return editting;
	}

	public void setEditting(boolean editting) {
		this.editting = editting;
	}
	
}
