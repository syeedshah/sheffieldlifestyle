package org.lifestyle.com.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_kids")
public class Kids implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5527566248002296042L;
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "largeDescription")
	private String largeDescription;
	@Column(name = "address")
	private String address;
	@Column(name = "website")
	private String website;
	@Column(name = "phone_no")
	private String phoneNo;
	@Column(name = "email")
	private String email;
	@Column(name = "rating")
	private BigInteger rating;
	@Column(name = "mapx")
	private String mapx;
	@Column(name = "mapy")
	private String mapy;
	@Column(name = "price")
	private BigDecimal price;
	@Column(name = "opening_times")
	private String openingTimes;
	@Column(name = "pending_verification")
	private int pendingVerification;
//	@Column(name = "created_at")
//	private Date createdAt; 
//	@Column(name = "updated_at")
//	private Date updatedAt;
	
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
	 * @return the emiratesId
	 */
	
	/**
	 * @return the largeDescription
	 */
	public String getLargeDescription() {
		return largeDescription;
	}
	/**
	 * @param largeDescription the largeDescription to set
	 */
	public void setLargeDescription(String largeDescription) {
		this.largeDescription = largeDescription;
	}/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}
	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}
	/**
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}
	/**
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the rating
	 */
	public BigInteger getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(BigInteger rating) {
		this.rating = rating;
	}
	/**
	 * @return the mapx
	 */
	public String getMapx() {
		return mapx;
	}
	/**
	 * @param mapx the mapx to set
	 */
	public void setMapx(String mapx) {
		this.mapx = mapx;
	}
	/**
	 * @return the mapy
	 */
	public String getMapy() {
		return mapy;
	}
	/**
	 * @param mapy the mapy to set
	 */
	public void setMapy(String mapy) {
		this.mapy = mapy;
	}
	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * @return the openingTimes
	 */
	public String getOpeningTimes() {
		return openingTimes;
	}
	/**
	 * @param openingTimes the openingTimes to set
	 */
	public void setOpeningTimes(String openingTimes) {
		this.openingTimes = openingTimes;
	}
	/**
	 * @return the pendingVerification
	 */
	public int getPendingVerification() {
		return pendingVerification;
	}
	/**
	 * @param pendingVerification the pendingVerification to set
	 */
	public void setPendingVerification(int pendingVerification) {
		this.pendingVerification = pendingVerification;
	}

}
