package com.example.dashboardbackend.controller;

import com.example.dashboardbackend.bean.DataHistory;
import com.example.dashboardbackend.result.DataHistoryResult;
import com.example.dashboardbackend.service.DataHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DataHistoryController {

    //将Service注入web层
    @Autowired
    DataHistoryService dataHistoryService;

    DataHistory dataHistory;

    //Get Data History
    @RequestMapping("/api/getDataHistory")
    @ResponseBody
    public DataHistoryResult getDataHistory(@RequestBody DataHistory dataHistory){
        List<DataHistory> list = dataHistoryService.getDataHistory();
        Integer total = dataHistoryService.getDataHistoryCount();
        DataHistoryResult dataHistoryResult = new DataHistoryResult(1000,"query successful!",list,total);
        System.out.println(dataHistoryResult);
        return dataHistoryResult;
    }

    //Get Student CarPlate
    @RequestMapping("/api/getUnDataHistory")
    @ResponseBody
    public DataHistoryResult getUnDataHistory(@RequestBody DataHistory dataHistory){
        List<DataHistory> list = dataHistoryService.getUnDataHistory();
        Integer total = dataHistoryService.getUnDataHistoryCount();
        DataHistoryResult dataHistoryResult = new DataHistoryResult(1000,"query successful!",list,total);
        System.out.println(dataHistoryResult);
        return dataHistoryResult;
    }

}
