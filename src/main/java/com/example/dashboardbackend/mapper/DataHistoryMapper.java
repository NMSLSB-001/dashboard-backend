package com.example.dashboardbackend.mapper;

import com.example.dashboardbackend.bean.DataHistory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataHistoryMapper {

    //
    public List<DataHistory> getDataHistory();

    public List<DataHistory> getUnDataHistory();

    //
    public Integer getDataHistoryCount();

    public Integer getUnDataHistoryCount();
}
