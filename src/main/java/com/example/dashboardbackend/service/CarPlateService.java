package com.example.dashboardbackend.service;

import com.example.dashboardbackend.bean.CarPlate;
import com.example.dashboardbackend.bean.DataPaginationRequest;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface CarPlateService {

    // Get all CarPlate
    public List<CarPlate> getCarPlate();

    public PageInfo<CarPlate> getCarPlatePagination(DataPaginationRequest dataPaginationRequest);

    // Number of record
    public Integer getCarPlateCount();

    // Add CarPlate
    public void addCarPlate(CarPlate carPlate);

    // Edit CarPlate
    public void editCarPlate(CarPlate carPlate);

    // Delete CarPlate
    public void deleteCarPlate(CarPlate carPlate);
}
