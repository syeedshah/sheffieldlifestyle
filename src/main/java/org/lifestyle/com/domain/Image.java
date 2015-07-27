package org.lifestyle.com.domain;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_images")
public class Image implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5527566248002296042L;
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer image_id;
	@Column(name = "image_link")
	private String imageLink;
	@Column(name = "name")
	private String name;
	@Column(name = "ext")
	private String ext;
	@Column(name = "width")
	private BigInteger width;
	@Column(name = "height")
	private BigInteger height;
	@Column(name = "album")
	private String album;
	@Column(name = "image_no")
	private BigInteger imageNo;
	@Column(name = "category")
	private String category;
	@Column(name = "size")
	private String size;
	@Column(name = "mime")
	private String mime; 
	@Column(name = "image")
	private String imagePath;
 
	/**
	 * @return the image_id
	 */
	public Integer getImage_id() {
		return image_id;
	}

	/**
	 * @param image_id the image_id to set
	 */
	public void setImage_id(Integer image_id) {
		this.image_id = image_id;
	}

	/**
	 * @return the imageLink
	 */
	public String getImageLink() {
		return imageLink;
	}

	/**
	 * @param imageLink the imageLink to set
	 */
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
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
	 * @return the ext
	 */
	public String getExt() {
		return ext;
	}

	/**
	 * @param ext the ext to set
	 */
	public void setExt(String ext) {
		this.ext = ext;
	}

	/**
	 * @return the width
	 */
	public BigInteger getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(BigInteger width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public BigInteger getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(BigInteger height) {
		this.height = height;
	}

	/**
	 * @return the album
	 */
	public String getAlbum() {
		return album;
	}

	/**
	 * @param album the album to set
	 */
	public void setAlbum(String album) {
		this.album = album;
	}

	/**
	 * @return the imageNo
	 */
	public BigInteger getImageNo() {
		return imageNo;
	}

	/**
	 * @param imageNo the imageNo to set
	 */
	public void setImageNo(BigInteger imageNo) {
		this.imageNo = imageNo;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return the mime
	 */
	public String getMime() {
		return mime;
	}

	/**
	 * @param mime the mime to set
	 */
	public void setMime(String mime) {
		this.mime = mime;
	}

	/**
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * @param imagePath the imagePath to set
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	} 
	
	@Override
    public String toString() {
        return "Landmark{" +
                "id=" + image_id +
                ", name='" + name + '\'' +
              //  ", website=" + website +
                '}';
    }
}
