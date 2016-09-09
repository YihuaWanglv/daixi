package com.iyihua.daixi.web.dto;

import com.iyihua.daixi.model.Point;

public class PointView extends Point {

	private boolean editting = false;
	private String detail;

	public boolean getEditting() {
		return editting;
	}

	public void setEditting(boolean editting) {
		this.editting = editting;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
