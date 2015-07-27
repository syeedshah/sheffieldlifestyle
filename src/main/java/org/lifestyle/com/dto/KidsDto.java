package org.lifestyle.com.dto;

import java.io.Serializable;

 
public class KidsDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 
	private Integer id; 
	private String name; 
	private String largeDescription; 
	private String email; 
	private String imgPath;
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
	 * @return the imgPath
	 */
	public String getImgPath() {
		return imgPath;
	}
	/**
	 * @param imgPath the imgPath to set
	 */
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	} 
}
