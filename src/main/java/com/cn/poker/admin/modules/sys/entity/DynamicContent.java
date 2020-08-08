package com.cn.poker.admin.modules.sys.entity;

import java.util.Date;

/**
 * 多语言动态内容
 */
public class DynamicContent {

    /**
     * 无参构造
     */
    public DynamicContent() {}

    /**
     * 有参构造需要生成uuid
     * @param dataId
     * @param languageName
     * @param tableName
     * @param tableRemark
     */
    public DynamicContent(String dataId, String languageName, String tableName, String tableRemark) {
        this.dataId = dataId;
        this.languageName = languageName;
        this.tableName = tableName;
        this.tableRemark = tableRemark;
    }

    /**
     * 有参构造不需要生成uuid
     * @param contentId
     * @param dataId
     * @param languageName
     * @param tableName
     * @param tableRemark
     */
    public DynamicContent(String contentId, String dataId, String languageName, String tableName, String tableRemark) {
        this.contentId = contentId;
        this.dataId = dataId;
        this.languageName = languageName;
        this.tableName = tableName;
        this.tableRemark = tableRemark;
    }

    /**
     * 主键
     */
    private String contentId;

    /**
     * 数据ID
     */
    private String dataId;

    /**
     * 语言简写名称
     */
    private String languageCode;

    /**
     * 语言名称
     */
    private String languageName;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 表说明
     */
    private String tableRemark;

    /**
     * 表字段
     */
    private String fieldName;

    /**
     * 字段说明
     */
    private String fieldRemark;

    /**
     * 数据内容
     */
    private String dataContent;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableRemark() {
        return tableRemark;
    }

    public void setTableRemark(String tableRemark) {
        this.tableRemark = tableRemark;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldRemark() {
        return fieldRemark;
    }

    public void setFieldRemark(String fieldRemark) {
        this.fieldRemark = fieldRemark;
    }

    public String getDataContent() {
        return dataContent;
    }

    public void setDataContent(String dataContent) {
        this.dataContent = dataContent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
