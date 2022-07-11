package com.example.dashboardbackend.service;

import com.example.dashboardbackend.bean.DataHistory;
import com.example.dashboardbackend.bean.DataPaginationRequest;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface DataHistoryService {

    // Get all
    public List<DataHistory> getDataHistory();

    public List<DataHistory> getUnDataHistory();

    public PageInfo<DataHistory> getDataHistoryPagination(DataPaginationRequest dataPaginationRequest);


    // Number of record
    public Integer getDataHistoryCount();

    public Integer getUnDataHistoryCount();
}
