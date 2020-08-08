package com.cn.poker.admin.common.utils;


public class ExcelTheadUtil {

    private String title;
    private int firstRow;
    private int lastRow;
    private int firstCol;
    private int lastCol;

    public ExcelTheadUtil(String title, int firstRow, int lastRow, int firstCol, int lastCol) {
        this.title = title;
        this.firstRow = firstRow;
        this.lastRow = lastRow;
        this.firstCol = firstCol;
        this.lastCol = lastCol;
    }

    public String getTitle() {
        return title;
    }

    public int getFirstRow() {
        return firstRow;
    }

    public int getLastRow() {
        return lastRow;
    }

    public int getFirstCol() {
        return firstCol;
    }

    public int getLastCol() {
        return lastCol;
    }
}
