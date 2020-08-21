package com.cn.poker.admin.modules.poker.entity;

public class Strate {
    private int id;        //策略包主键
    private String name;   //名称
    private int type;       //类型    1---6人桌   2---8人桌
    private int poolType;   //底池    1

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPoolType() {
        return poolType;
    }

    public void setPoolType(int poolType) {
        this.poolType = poolType;
    }
}
