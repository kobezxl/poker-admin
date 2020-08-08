package com.cn.poker.admin.modules.sys.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * APP版本表
 */
public class TVersionEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 编号
	 */
	private Long id;
	
	/**
	 * 版本号
	 */
	private String version;
	
	/**
	 * 描述
	 */
	private String description;
	
	/**
	 * 是否需要升级
	 */
	private Integer protect;
	
	/**
	 * 版本地址
	 */
	private String hotUrl;
	
	/**
	 * 启动页面地址
	 */
	private String content;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 修改时间
	 */
	private Date updateTime;
	

	public TVersionEntity() {
		super();
	}

    /**
     * setter for id
     * @param id
     */
	public void setId(Long id) {
		this.id = id;
	}

    /**
     * getter for id
     */
	public Long getId() {
		return id;
	}
	
    /**
     * setter for version
     * @param version
     */
	public void setVersion(String version) {
		this.version = version;
	}

    /**
     * getter for version
     */
	public String getVersion() {
		return version;
	}
	
    /**
     * setter for description
     * @param description
     */
	public void setDescription(String description) {
		this.description = description;
	}

    /**
     * getter for description
     */
	public String getDescription() {
		return description;
	}
	
    /**
     * setter for protect
     * @param protect
     */
	public void setProtect(Integer protect) {
		this.protect = protect;
	}

    /**
     * getter for protect
     */
	public Integer getProtect() {
		return protect;
	}
	
    /**
     * setter for hotUrl
     * @param hotUrl
     */
	public void setHotUrl(String hotUrl) {
		this.hotUrl = hotUrl;
	}

    /**
     * getter for hotUrl
     */
	public String getHotUrl() {
		return hotUrl;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
