package com.iyihua.daixi.model;

//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;

public class UserItem {
	
//	@Id
//	@GeneratedValue
    private Integer ilid;
//	@Column
    private Integer uid;
//	@Column
    private Integer iid;
//	@Column
    private Byte level;
//	@Column
    private Byte pointLevel;

    public Integer getIlid() {
        return ilid;
    }

    public void setIlid(Integer ilid) {
        this.ilid = ilid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Byte getPointLevel() {
        return pointLevel;
    }

    public void setPointLevel(Byte pointLevel) {
        this.pointLevel = pointLevel;
    }
}