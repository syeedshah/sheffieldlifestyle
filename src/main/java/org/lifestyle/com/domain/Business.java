package org.lifestyle.com.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tbl_business")
public class Business implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5527566248002296042L;
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int businessid;
	@Column(name = "name")
	private String name;
	@Column(name = "largeDescription")
	private String largeDescription;
	@Column(name = "smallDescription")
	private String smallDescription;
	@Column(name = "address")
	private String address;
	@Column(name = "website")
	private String website;
	@Column(name = "phone_no")
	private String phone_no;
	@Column(name = "email")
	private String email;
	@Column(name = "rating")
	private Integer rating;
	@Column(name = "mapx")
	private String mapx;
	@Column(name = "mapy")
	private String mapy;
	@Column(name = "price")
	private String price;
	@Column(name = "opening_times")
	private String opening_times;
	@Column(name = "pending_verification")
	private int pending_verification;
	//@Column(name = "created_at")
	//@DateTimeFormat(pattern = "yyyy/MM/dd")
	//private Date created_at;
	//@Column(name = "updated_at")
	//@DateTimeFormat(pattern = "yyyy/MM/dd")
	//private Date updated_at;

	public int getbusiness_id() {
		return businessid;
	}

	public void setbusiness_id(int business_id) {
		this.businessid = business_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLargeDescription() {
		return largeDescription;
	}

	public void setLargeDescription(String largeDescription) {
		this.largeDescription = largeDescription;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getMapx() {
		return mapx;
	}

	public void setMapx(String mapx) {
		this.mapx = mapx;
	}

	public String getMapy() {
		return mapy;
	}

	public void setMapy(String mapy) {
		this.mapy = mapy;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getOpening_times() {
		return opening_times;
	}

	public void setOpening_times(String opening_times) {
		this.opening_times = opening_times;
	}

	public int getPending_verification() {
		return pending_verification;
	}

	public void setPending_verification(int pending_verification) {
		this.pending_verification = pending_verification;
	}

	
	@Override
    public String toString() {
        return "Dining{" +
                "id=" + businessid +
                ", name='" + name + '\'' +
                ", website=" + website +
                '}';
    }

}
