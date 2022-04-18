package com.example.dashboardbackend.service;

import com.example.dashboardbackend.bean.SystemStatus;

import java.util.List;

public interface SystemStatusService {

    // Get all
    public List<SystemStatus> getSystemStatus(Integer serviceID);
}
