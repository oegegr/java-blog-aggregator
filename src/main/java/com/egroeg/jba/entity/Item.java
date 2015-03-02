package com.egroeg.jba.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Item {
	@Id
	@GeneratedValue
	private Integer id;
	private String title;
	private String description;
	@Column(name = "published_date")
	private Date publishedDate;
	private String link;
	@ManyToOne
	@JoinColumn(name = "blog_id")
	private Blog blog;

	public String getDescription() {
		return description;
	}

	public Integer getId() {
		return id;
	}

	public String getLink() {
		return link;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public String getTitle() {
		return title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

}
