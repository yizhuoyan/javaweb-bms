package com.valentinalee.bms.vo;

import java.util.Date;

public class StudentVO {

	public static final String MALE="男";
	
	public static final String FEMALE="女";
	/**
	 * id
	 */
	private String id;
	
	/**
	 * 学生学号
	 */
	private String no;
	
	
	public String getNo() {
		return this.no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	/**
	 * 学生姓名
	 */
	private String name;
	
	/**
	 * 学生性别
	 */
	private String sex;
	
	/**
	 * 学生入学时间
	 */
	private Date enterDay;
	
	/**
	 * 学生毕业时间
	 */
	private Date graduateDay;

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

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getEnterDay() {
		return this.enterDay;
	}

	public void setEnterDay(Date enterDay) {
		this.enterDay = enterDay;
	}

	public Date getGraduateDay() {
		return this.graduateDay;
	}

	public void setGraduateDay(Date graduateDay) {
		this.graduateDay = graduateDay;
	}
}
