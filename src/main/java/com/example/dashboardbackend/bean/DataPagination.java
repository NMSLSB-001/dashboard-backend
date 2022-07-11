package com.example.dashboardbackend.bean;

import java.util.Collection;
import java.util.List;

public class DataPagination {

    private int pageNum;
    private int pageSize;
    private long totalSize;
    private int totalPages;
    private List<?> list;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalSize() {
        return totalSize;
    }
    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }
    public int getTotalPages() {
        return totalPages;
    }
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
    public List<?> getContent() {
        return list;
    }
    public void setContent(List<?> list) {
        this.list = list;
    }
}
