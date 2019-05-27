/**
 * 
 */
package org.fkit.shoppingApp.bean;

import java.util.Date;

/**
 * @author 罗春龙
 * Version 1.0
 * 2018年10月11日
 * 用于封装书籍信息
 */
public class Book {
	
	private Integer id;//用户id
	private String name;//书籍名字
	private String author;//作者
	private Date publicationdate;//出版时间
	private String publication;//出版社
	private Double price;//价格
	private String image;//图片地址|图片名称
	private String remark;//备注信息
	
	

	
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the publicationdate
	 */
	public Date getPublicationdate() {
		return publicationdate;
	}
	/**
	 * @param publicationdate the publicationdate to set
	 */
	public void setPublicationdate(Date publicationdate) {
		this.publicationdate = publicationdate;
	}
	/**
	 * @return the publication
	 */
	public String getPublication() {
		return publication;
	}
	/**
	 * @param publication the publication to set
	 */
	public void setPublication(String publication) {
		this.publication = publication;
	}
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	
	

}
