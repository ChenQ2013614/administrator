/**
 * 
 */
package org.fkit.shoppingApp.bean;

import java.util.Date;

/**
 * @author 罗春龙
 * Version 1.0
 * 2018年10月11日
 * 用于封装用户信息
 */
public class Order {
	
	private Integer id;//订单id
	private String orderNo;//订单编号
	private Date createDate;//下单时间
	private Date outDate;//发货时间
	private Integer userId;//用户id
	private double money;//订单总金额
	
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the orderNo
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * @param orderNo the orderNo to set
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * @return the outDate
	 */
	public Date getOutDate() {
		return outDate;
	}
	/**
	 * @param outDate the outDate to set
	 */
	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}
	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * @return the money
	 */
	public double getMoney() {
		return money;
	}
	/**
	 * @param money the money to set
	 */
	public void setMoney(double money) {
		this.money = money;
	}
	
	
	
	
	
	

}
