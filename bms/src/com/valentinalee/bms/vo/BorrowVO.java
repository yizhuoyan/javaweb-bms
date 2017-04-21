package com.valentinalee.bms.vo;

import java.util.Date;

public class BorrowVO {

	/**
	 * 借书编号
	 */
	private String id;
	
	/**
	 * 学生编号
	 */
	private StudentVO student;
	
	/**
	 * 图书编号
	 */
	private BookVO book;
	
	/**
	 * 借出时间
	 */
	private Date borrowOutTime;
	
	/**
	 * 借阅天数
	 */
	private int borrowDay; 
	
	/**
	 * 最大归还期限
	 */
	private Date mustGiveBackTime;
	
	/**
	 * 实际还书时间
	 */
	private Date giveBackTime;
	
	/**
	 * 归还异常类型
	 */
	private String giveBackErrorType;
	
	/**
	 * 归还描述
	 */
	private String remark;
	
	/**
	 * 借出时的管理员
	 */
	private ManagerVO borrowOutManager;	
	/**
	 * 还书时的管理员
	 */
	private ManagerVO giveBackManager;
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public StudentVO getStudent() {
		return this.student;
	}
	public void setStudent(StudentVO student) {
		this.student = student;
	}
	public BookVO getBook() {
		return this.book;
	}
	public void setBook(BookVO book) {
		this.book = book;
	}
	public Date getBorrowOutTime() {
		return this.borrowOutTime;
	}
	public void setBorrowOutTime(Date borrowOutTime) {
		this.borrowOutTime = borrowOutTime;
	}
	public int getBorrowDay() {
		return this.borrowDay;
	}
	public void setBorrowDay(int borrowDay) {
		this.borrowDay = borrowDay;
	}
	public Date getMustGiveBackTime() {
		return this.mustGiveBackTime;
	}
	public void setMustGiveBackTime(Date mustGiveBackTime) {
		this.mustGiveBackTime = mustGiveBackTime;
	}
	public Date getGiveBackTime() {
		return this.giveBackTime;
	}
	public void setGiveBackTime(Date giveBackTime) {
		this.giveBackTime = giveBackTime;
	}
	public String getGiveBackErrorType() {
		return this.giveBackErrorType;
	}
	public void setGiveBackErrorType(String giveBackErrorType) {
		this.giveBackErrorType = giveBackErrorType;
	}
	public String getRemark() {
		return this.remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public ManagerVO getBorrowOutManager() {
		return this.borrowOutManager;
	}
	public void setBorrowOutManager(ManagerVO borrowOutManager) {
		this.borrowOutManager = borrowOutManager;
	}
	public ManagerVO getGiveBackManager() {
		return this.giveBackManager;
	}
	public void setGiveBackManager(ManagerVO giveBackManager) {
		this.giveBackManager = giveBackManager;
	}


}
