package com.example.dashboardbackend.bean;

public class DataPaginationRequest {

    private Integer userId;
    private int requestPageNum;
    private int requestPageSize;

    public Integer getUserId() {
        return userId;
    }

    public int getRequestPageNum() {
        return requestPageNum;
    }

    public void setRequestPageNum(int requestPageNum) {
        this.requestPageNum = requestPageNum;
    }

    public int getRequestPageSize() {
        return requestPageSize;
    }

    public void setRequestPageSize(int requestPageSize) {
        this.requestPageSize = requestPageSize;
    }
}
