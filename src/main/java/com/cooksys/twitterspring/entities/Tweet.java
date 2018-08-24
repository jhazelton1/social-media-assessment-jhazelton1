package com.cooksys.twitterspring.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Tweet {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	@ManyToOne
	private User author;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(nullable = false)
	private Timestamp posted;

	private String content;

	@OneToOne
	private Tweet inReplyTo;

	@OneToOne
	private Tweet repostOf;

	public Tweet() {

	}

	public Tweet(Integer id, User author, Timestamp posted) {
		super();
		this.id = id;
		this.author = author;
		this.posted = posted;
	}

	public Tweet(Integer id, User author, Timestamp posted, String content, Tweet inReplyTo, Tweet repostOf) {
		super();
		this.id = id;
		this.author = author;
		this.posted = posted;
		this.content = content;
		this.inReplyTo = inReplyTo;
		this.repostOf = repostOf;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Timestamp getPosted() {
		return posted;
	}

	public void setPosted(Timestamp posted) {
		this.posted = posted;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Tweet getInReplyTo() {
		return inReplyTo;
	}

	public void setInReplyTo(Tweet inReplyTo) {
		this.inReplyTo = inReplyTo;
	}

	public Tweet getRepostOf() {
		return repostOf;
	}

	public void setRepostOf(Tweet repostOf) {
		this.repostOf = repostOf;
	}

}
