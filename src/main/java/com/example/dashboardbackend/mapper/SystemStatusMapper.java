package com.example.dashboardbackend.mapper;

import com.example.dashboardbackend.bean.SystemStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SystemStatusMapper {

    //
    public List<SystemStatus> getSystemStatus(Integer serviceID);
}
