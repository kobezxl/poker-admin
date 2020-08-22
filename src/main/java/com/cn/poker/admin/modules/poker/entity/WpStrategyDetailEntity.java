package com.cn.poker.admin.modules.poker.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * @author <>
 */
public class WpStrategyDetailEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;
	
	/**
	 * 
	 */
	private Integer userId;
	
	/**
	 * 
	 */
	private Date startDate;
	
	/**
	 * 
	 */
	private Date endDate;
	
	/**
	 * 
	 */
	private Integer poolType;
	
	/**
	 * 
	 */
	private Integer type;
	
	/**
	 * 
	 */
	private Integer gold;
	
	/**
	 * 
	 */
	private Integer typeDate;
	
	/**
	 * 
	 */
	private Date createDate;
	
	/**
	 * 
	 */
	private Integer strategyId;
	
	/**
	 * 
	 */
	private Integer dayCount;


	private String typeNum;
	private  String userLogin;  //登录名
	private  String userEmail;  //邮箱
	private  String userNicename;  //昵称

	private int dataFrom;    //是否是系统赠送:1-是，0-否

	private String msg;
	private String name ;  //策略包名称

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getDataFrom() {
		return dataFrom;
	}

	public void setDataFrom(int dataFrom) {
		this.dataFrom = dataFrom;
	}

	public String getTypeNum() {
		return typeNum;
	}

	public void setTypeNum(String typeNum) {
		this.typeNum = typeNum;
	}

	public String getUserNicename() {
		return userNicename;
	}

	public void setUserNicename(String userNicename) {
		this.userNicename = userNicename;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public WpStrategyDetailEntity() {
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
     * setter for userId
     * @param userId
     */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

    /**
     * getter for userId
     */
	public Integer getUserId() {
		return userId;
	}
	
    /**
     * setter for startDate
     * @param startDate
     */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

    /**
     * getter for startDate
     */
	public Date getStartDate() {
		return startDate;
	}
	
    /**
     * setter for endDate
     * @param endDate
     */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

    /**
     * getter for endDate
     */
	public Date getEndDate() {
		return endDate;
	}
	
    /**
     * setter for poolType
     * @param poolType
     */
	public void setPoolType(Integer poolType) {
		this.poolType = poolType;
	}

    /**
     * getter for poolType
     */
	public Integer getPoolType() {
		return poolType;
	}
	
    /**
     * setter for type
     * @param type
     */
	public void setType(Integer type) {
		this.type = type;
	}

    /**
     * getter for type
     */
	public Integer getType() {
		return type;
	}
	
    /**
     * setter for gold
     * @param gold
     */
	public void setGold(Integer gold) {
		this.gold = gold;
	}

    /**
     * getter for gold
     */
	public Integer getGold() {
		return gold;
	}
	
    /**
     * setter for typeDate
     * @param typeDate
     */
	public void setTypeDate(Integer typeDate) {
		this.typeDate = typeDate;
	}

    /**
     * getter for typeDate
     */
	public Integer getTypeDate() {
		return typeDate;
	}
	
    /**
     * setter for createDate
     * @param createDate
     */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

    /**
     * getter for createDate
     */
	public Date getCreateDate() {
		return createDate;
	}
	
    /**
     * setter for strategyId
     * @param strategyId
     */
	public void setStrategyId(Integer strategyId) {
		this.strategyId = strategyId;
	}

    /**
     * getter for strategyId
     */
	public Integer getStrategyId() {
		return strategyId;
	}
	
    /**
     * setter for dayCount
     * @param dayCount
     */
	public void setDayCount(Integer dayCount) {
		this.dayCount = dayCount;
	}

    /**
     * getter for dayCount
     */
	public Integer getDayCount() {
		return dayCount;
	}
	
}
