package com.cn.poker.admin.modules.poker.entity;

import java.io.Serializable;



/**
 * 
 * @author <>
 */
public class WpStrategyPriceEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;
	
	/**
	 * 
	 */
	private Integer month;
	
	/**
	 * 
	 */
	private Integer year;
	
	/**
	 * 
	 */
	private Integer forver;
	
	/**
	 * 
	 */
	private String type;
	

	public WpStrategyPriceEntity() {
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
     * setter for month
     * @param month
     */
	public void setMonth(Integer month) {
		this.month = month;
	}

    /**
     * getter for month
     */
	public Integer getMonth() {
		return month;
	}
	
    /**
     * setter for year
     * @param year
     */
	public void setYear(Integer year) {
		this.year = year;
	}

    /**
     * getter for year
     */
	public Integer getYear() {
		return year;
	}
	
    /**
     * setter for forver
     * @param forver
     */
	public void setForver(Integer forver) {
		this.forver = forver;
	}

    /**
     * getter for forver
     */
	public Integer getForver() {
		return forver;
	}
	
    /**
     * setter for type
     * @param type
     */
	public void setType(String type) {
		this.type = type;
	}

    /**
     * getter for type
     */
	public String getType() {
		return type;
	}
	
}
