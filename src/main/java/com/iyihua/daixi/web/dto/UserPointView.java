package com.iyihua.daixi.web.dto;

import com.iyihua.daixi.model.UserPoint;

public class UserPointView extends UserPoint {

	private boolean editting = false;

	public boolean getEditting() {
		return editting;
	}

	public void setEditting(boolean editting) {
		this.editting = editting;
	}
}
