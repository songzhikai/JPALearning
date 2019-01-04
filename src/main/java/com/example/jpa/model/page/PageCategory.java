package com.example.jpa.model.page;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 页面组件实体类
 * 
 * @author zuobin
 * @create 2018-05-24
 **/
@Entity
@Table(name = "EPM_CONTENT_PAGE_CATEGORY")
public class PageCategory {
	@Id
	@Column(name = "categoryId", columnDefinition = ("varchar(50)"))
	private String categoryId;
	
	@Column(name = "categoryName", columnDefinition = ("varchar(50) default null"))
	private String categoryName;

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	

}
