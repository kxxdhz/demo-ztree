package com.demo.ztree.entity;

import java.io.Serializable;
/**
 * 模块：实体类
 * 功能：对于数据库的视图生成的实体类
 * @author lvPeng
 * @data 2016.04.15
 */
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id; //ID
	private String name;//菜单名字
	private String pid; //菜单的父ID
	private String url; //菜单打开的地址
	private String target; //菜单在某个frame或者Iframe打开
	private Boolean checked; //是否选中
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPid() {
		return pid;
	}
	
	public void setPid(String pid) {
		this.pid = pid;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getTarget() {
		return target;
	}
	
	public void setTarget(String target) {
		this.target = target;
	}

	public Boolean getChecked() {
		return this.checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

}
