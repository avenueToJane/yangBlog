package com.yang.blog.website.model.Vo;

import java.io.Serializable;

public class SummaryVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7737987178813101130L;
	
	 private Integer id;
	 
	 private String createTime;
	 
	 private String title;
	 
	 private String content;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
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

	@Override
	public String toString() {
		return "SummaryVo [id=" + id + ", createTime=" + createTime + ", title=" + title + ", content=" + content + "]";
	}
	 
	
	 
	
	

}
