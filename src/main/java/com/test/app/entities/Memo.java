package com.test.app.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbmemo",schema="memo")
public class Memo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="userid")
	private int userid;
	@Column(name="title")
	private String title;
	@Column(name="content")
	private String content;
	@Column(name="domain")
	private String domain;
	@Column(name="url")
	private String url;
	@Column(name="date")
	private Date date;
	@Column(name="isenable")
	private boolean isenable = true;
	@Column(name="ispublic")
	private boolean ispublic;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isIsenable() {
		return isenable;
	}
	public void setIsenable(boolean isenable) {
		this.isenable = isenable;
	}
	public boolean isIspublic() {
		return ispublic;
	}
	public void setIspublic(boolean ispublic) {
		this.ispublic = ispublic;
	}
	@Override
	public String toString() {
		return "Memo [id=" + id + ", userid=" + userid + ", title=" + title + ", content=" + content + ", domain="
				+ domain + ", url=" + url + ", date=" + date + ", isenable=" + isenable + ", ispublic=" + ispublic
				+ "]";
	}
	public Memo(int id, int userid, String title, String content, String domain, String url, Date date,
			boolean isenable, boolean ispublic) {
		super();
		this.id = id;
		this.userid = userid;
		this.title = title;
		this.content = content;
		this.domain = domain;
		this.url = url;
		this.date = date;
		this.isenable = isenable;
		this.ispublic = ispublic;
	}
	public Memo(){}
}
