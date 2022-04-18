package com.example.dashboardbackend.service.Impl;

import com.example.dashboardbackend.bean.SystemStatus;
import com.example.dashboardbackend.mapper.SystemStatusMapper;
import com.example.dashboardbackend.service.SystemStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemStatusServiceImpl implements SystemStatusService {

    @Autowired
    SystemStatusMapper systemStatusMapper;

    @Override
    public List<SystemStatus> getSystemStatus(Integer serviceID) {

        return systemStatusMapper.getSystemStatus(serviceID);
    }
}
