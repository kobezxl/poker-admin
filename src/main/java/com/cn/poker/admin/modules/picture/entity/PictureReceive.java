package com.cn.poker.admin.modules.picture.entity;

import org.springframework.web.multipart.MultipartFile;

public class PictureReceive {

    /**
     * 类名
     */
    private String typeName;

    /**
     * 文件
     */
    private MultipartFile file;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
