package com.example.dashboardbackend.controller;

import com.example.dashboardbackend.bean.SystemStatus;
import com.example.dashboardbackend.result.SystemStatusResult;
import com.example.dashboardbackend.service.SystemStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SystemStatusController {

    //将Service注入web层
    @Autowired
    SystemStatusService systemStatusService;

    SystemStatus systemStatus;

    //Get System Status
    @RequestMapping("/api/getSystemStatus")
    @ResponseBody
    public SystemStatusResult getDataHistory(@RequestParam(value="serviceID", required = false) Integer serviceID) {
        List<SystemStatus> list = systemStatusService.getSystemStatus(serviceID);
        SystemStatusResult systemStatusResult = new SystemStatusResult(1000, "query successful!", list);
        System.out.println(systemStatusResult);
        return systemStatusResult;
    }
}
