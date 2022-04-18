package com.example.dashboardbackend.service.Impl;

import com.example.dashboardbackend.bean.DataHistory;
import com.example.dashboardbackend.mapper.DataHistoryMapper;
import com.example.dashboardbackend.service.DataHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataHistoryServiceImpl implements DataHistoryService {

    @Autowired
    DataHistoryMapper dataHistoryMapper;

    @Override
    public List<DataHistory> getDataHistory() {

        return dataHistoryMapper.getDataHistory();
    }

    @Override
    public List<DataHistory> getUnDataHistory() {

        return dataHistoryMapper.getUnDataHistory();
    }

    @Override
    public Integer getDataHistoryCount() {

        return dataHistoryMapper.getDataHistoryCount();
    }

    @Override
    public Integer getUnDataHistoryCount() {

        return dataHistoryMapper.getUnDataHistoryCount();
    }
}
