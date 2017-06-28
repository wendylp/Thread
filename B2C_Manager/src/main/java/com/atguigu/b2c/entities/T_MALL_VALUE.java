package com.atguigu.b2c.entities;

import java.util.Date;

public class T_MALL_VALUE {

	private int id;
	private String shxzh;
	private String shfqy;
	private int shxm_id;
	private String shxzh_mch;
	private Date chjshj;

	
	
	@Override
	public String toString() {
		return "T_MALL_VALUE [id=" + id + ", shxzh=" + shxzh + ", shfqy=" + shfqy + ", shxm_id=" + shxm_id
				+ ", shxzh_mch=" + shxzh_mch + ", chjshj=" + chjshj + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShxzh() {
		return shxzh;
	}

	public void setShxzh(String shxzh) {
		this.shxzh = shxzh;
	}

	public String getShfqy() {
		return shfqy;
	}

	public void setShfqy(String shfqy) {
		this.shfqy = shfqy;
	}

	public int getShxm_id() {
		return shxm_id;
	}

	public void setShxm_id(int shxm_id) {
		this.shxm_id = shxm_id;
	}

	public String getShxzh_mch() {
		return shxzh_mch;
	}

	public void setShxzh_mch(String shxzh_mch) {
		this.shxzh_mch = shxzh_mch;
	}

	public Date getChjshj() {
		return chjshj;
	}

	public void setChjshj(Date chjshj) {
		this.chjshj = chjshj;
	}

}
