package com.iyihua.daixi.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class UserPoint {
	
	@Id
	@GeneratedValue
    private Integer upid;
	@Column
    private Integer pid;
	@Column
    private String detail;
	@Column
    private Byte option;
	@Column
    private Byte score;

    public Integer getUpid() {
        return upid;
    }

    public void setUpid(Integer upid) {
        this.upid = upid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Byte getOption() {
        return option;
    }

    public void setOption(Byte option) {
        this.option = option;
    }

    public Byte getScore() {
        return score;
    }

    public void setScore(Byte score) {
        this.score = score;
    }
}