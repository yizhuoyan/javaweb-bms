package com.valentinalee.bms.vo;

import java.util.Date;

public class ManagerVO {

	/**
	 * 管理员编号
	 */
	private String id;
	
	/**
	 * 管理员姓名
	 */
	private String name;
	
	/**
	 * 管理员账号
	 */
	private String account;
	
	/**
	 * 管理员密码
	 */
	private String password;
	
	/**
	 * 管理员加入时间
	 */
	private Date createTime;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
