package com.example.dashboardbackend.service;

import com.example.dashboardbackend.bean.DataHistory;

import java.util.List;


public interface DataHistoryService {

    // Get all
    public List<DataHistory> getDataHistory();

    public List<DataHistory> getUnDataHistory();

    // Number of record
    public Integer getDataHistoryCount();

    public Integer getUnDataHistoryCount();
}
