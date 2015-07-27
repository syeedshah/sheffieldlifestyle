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
@Table(name = "banner")
public class Banner implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5527566248002296042L;
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "content")
	private String content;
	@Column(name = "title")
	private String title;
	@Column(name = "description")
	private String description;
	@Column(name = "description_pos")
	private String description_pos;
	@Column(name = "starts_at")
	private Date starts_at;
	@Column(name = "ends_at")
	private Date ends_at;
	@Column(name = "weight")
	private int weight;
	@Column(name = "duration")
	private String duration;
	@Column(name = "link")
	private String link;
	@Column(name = "article_id")
	private String article_id;
	@Column(name = "type_id")
	private String type_id;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription_pos() {
		return description_pos;
	}

	public void setDescription_pos(String description_pos) {
		this.description_pos = description_pos;
	}

	public Date getStarts_at() {
		return starts_at;
	}

	public void setStarts_at(Date starts_at) {
		this.starts_at = starts_at;
	}

	public Date getEnds_at() {
		return ends_at;
	}

	public void setEnds_at(Date ends_at) {
		this.ends_at = ends_at;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getArticle_id() {
		return article_id;
	}

	public void setArticle_id(String article_id) {
		this.article_id = article_id;
	}

	public String getType_id() {
		return type_id;
	}

	public void setType_id(String type_id) {
		this.type_id = type_id;
	}

	public int getBanner_id() {
		return id;
	}

	public void setLandmark_id(int id) {
		this.id = id;
	}

	
	
	@Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", link=" + link +
                '}';
    }

}
