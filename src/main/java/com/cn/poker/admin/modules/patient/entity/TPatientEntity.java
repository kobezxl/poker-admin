package com.cn.poker.admin.modules.patient.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * @author <>
 */
public class TPatientEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;
	
	/**
	 * 
	 */
	private String name;
	
	/**
	 * 
	 */
	private Integer age;
	
	/**
	 * 
	 */
	private String sex;
	
	/**
	 * 
	 */
	private String picture;
	
	/**
	 * 
	 */
	private String photo;
	
	/**
	 * 
	 */
	private String history;
	
	/**
	 * 
	 */
	private Date createTime;
	
	/**
	 * 
	 */
	private Date updateTime;
	

	public TPatientEntity() {
		super();
	}

    /**
     * setter for id
     * @param id
     */
	public void setId(Integer id) {
		this.id = id;
	}

    /**
     * getter for id
     */
	public Integer getId() {
		return id;
	}
	
    /**
     * setter for name
     * @param name
     */
	public void setName(String name) {
		this.name = name;
	}

    /**
     * getter for name
     */
	public String getName() {
		return name;
	}
	
    /**
     * setter for age
     * @param age
     */
	public void setAge(Integer age) {
		this.age = age;
	}

    /**
     * getter for age
     */
	public Integer getAge() {
		return age;
	}
	
    /**
     * setter for sex
     * @param sex
     */
	public void setSex(String sex) {
		this.sex = sex;
	}

    /**
     * getter for sex
     */
	public String getSex() {
		return sex;
	}
	
    /**
     * setter for picture
     * @param picture
     */
	public void setPicture(String picture) {
		this.picture = picture;
	}

    /**
     * getter for picture
     */
	public String getPicture() {
		return picture;
	}
	
    /**
     * setter for photo
     * @param photo
     */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

    /**
     * getter for photo
     */
	public String getPhoto() {
		return photo;
	}
	
    /**
     * setter for history
     * @param history
     */
	public void setHistory(String history) {
		this.history = history;
	}

    /**
     * getter for history
     */
	public String getHistory() {
		return history;
	}
	
    /**
     * setter for createTime
     * @param createTime
     */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

    /**
     * getter for createTime
     */
	public Date getCreateTime() {
		return createTime;
	}
	
    /**
     * setter for updateTime
     * @param updateTime
     */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

    /**
     * getter for updateTime
     */
	public Date getUpdateTime() {
		return updateTime;
	}
	
}
