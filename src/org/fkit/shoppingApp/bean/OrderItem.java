/**
 * 
 */
package org.fkit.shoppingApp.bean;

/**
 * @author 罗春龙
 * Version 1.0
 * 2018年10月11日
 * 用于封装用户信息
 */
public class OrderItem {
	
      //订单id
	  private Integer orderId;
	  //购买数量
	  private Integer buyNum;
	  //书籍id
	  private Integer bookId;
	/**
	 * @return the orderId
	 */
	public Integer getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the buyNum
	 */
	public Integer getBuyNum() {
		return buyNum;
	}
	/**
	 * @param buyNum the buyNum to set
	 */
	public void setBuyNum(Integer buyNum) {
		this.buyNum = buyNum;
	}
	/**
	 * @return the bookId
	 */
	public Integer getBookId() {
		return bookId;
	}
	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	  
	  
	  
	

}
