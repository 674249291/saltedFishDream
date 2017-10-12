package com.saltedfish.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


public class BaseEntity implements Serializable {

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	/**
	 * 创建时间
	 */
	@Transient
	private Date createTime;
	
	/**
	 * 最后修改时间
	 */
	@Transient
	private Date lastModifyTime;

	@Transient
	private Integer page = 1;

	@Transient
	private Integer rows = 10;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}
}
