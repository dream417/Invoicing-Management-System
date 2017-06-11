package com.lzw.dao.model;

import java.io.Serializable;

public class TbRukuDetail implements Serializable {
	
	private String id;
	private String tbSpinfo;
	private String tbRukuMain;
	private Double dj;
	private Integer sl;

	public TbRukuDetail() {
	}

	public TbRukuDetail(String tbSpinfo, String tbRukuMain, Double dj,
			Integer sl) {
		this.tbSpinfo = tbSpinfo;
		this.tbRukuMain = tbRukuMain;
		this.dj = dj;
		this.sl = sl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTbSpinfo() {
		return tbSpinfo;
	}

	public void setTbSpinfo(String tbSpinfo) {
		this.tbSpinfo = tbSpinfo;
	}

	public String getTbRukuMain() {
		return tbRukuMain;
	}

	public void setTbRukuMain(String tbRukuMain) {
		this.tbRukuMain = tbRukuMain;
	}

	public Double getDj() {
		return dj;
	}

	public void setDj(Double dj) {
		this.dj = dj;
	}

	public Integer getSl() {
		return sl;
	}

	public void setSl(Integer sl) {
		this.sl = sl;
	}
}
