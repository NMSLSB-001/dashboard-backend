package com.example.dashboardbackend.controller;

import com.example.dashboardbackend.bean.DataHistory;
import com.example.dashboardbackend.bean.DataPagination;
import com.example.dashboardbackend.bean.DataPaginationRequest;
import com.example.dashboardbackend.result.DataHistoryResult;
import com.example.dashboardbackend.result.DataPaginationResult;
import com.example.dashboardbackend.service.DataHistoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public DataHistoryResult getDataHistory(@RequestBody DataHistory dataHistory) {
        List<DataHistory> list = dataHistoryService.getDataHistory();
        Integer total = dataHistoryService.getDataHistoryCount();
        DataHistoryResult dataHistoryResult = new DataHistoryResult(1000, "query successful!", list, total);
        System.out.println(dataHistoryResult);
        return dataHistoryResult;
    }

    @RequestMapping("/api/getDataHistoryPagination")
    @ResponseBody
    public DataPaginationResult getDataHistoryPagination(@RequestParam(name = "pageNum") String pageNum, @RequestParam(name = "pageSize") String pageSize) {
        DataPaginationRequest dataPaginationRequest = new DataPaginationRequest();
        dataPaginationRequest.setRequestPageNum(Integer.parseInt(pageNum));
        dataPaginationRequest.setRequestPageSize(Integer.parseInt(pageSize));
        PageInfo<DataHistory> pageInfo = dataHistoryService.getDataHistoryPagination(dataPaginationRequest);
        Integer total = dataHistoryService.getDataHistoryCount();
        DataPaginationResult dataPaginationResult = new DataPaginationResult(1000, "query successful!", pageInfo.getList(), pageInfo.getPageNum(), pageInfo.getPageSize(), total, pageInfo.getPages());
        System.out.println(dataPaginationResult);
        return dataPaginationResult;
    }

    //Get Student CarPlate
    @RequestMapping("/api/getUnDataHistory")
    @ResponseBody
    public DataHistoryResult getUnDataHistory(@RequestBody DataHistory dataHistory) {
        List<DataHistory> list = dataHistoryService.getUnDataHistory();
        Integer total = dataHistoryService.getUnDataHistoryCount();
        DataHistoryResult dataHistoryResult = new DataHistoryResult(1000, "query successful!", list, total);
        System.out.println(dataHistoryResult);
        return dataHistoryResult;
    }

}
