package com.example.dashboardbackend.service.Impl;

import com.example.dashboardbackend.bean.CarPlate;
import com.example.dashboardbackend.bean.DataPaginationRequest;
import com.example.dashboardbackend.mapper.CarPlateMapper;
import com.example.dashboardbackend.service.CarPlateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CarPlateServiceImpl implements CarPlateService {

    @Autowired
    CarPlateMapper carPlateMapper;

    @Override
    public List<CarPlate> getCarPlate() {

        return carPlateMapper.getCarPlate();
    }

    @Override
    public PageInfo<CarPlate> getCarPlatePagination(DataPaginationRequest dataPaginationRequest) {
        PageHelper.startPage(dataPaginationRequest.getRequestPageNum(), dataPaginationRequest.getRequestPageSize());
        List<CarPlate> list = carPlateMapper.getCarPlate();
        PageInfo<CarPlate> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Integer getCarPlateCount() {

        return carPlateMapper.getCarPlateCount();
    }

    @Override
    public void addCarPlate(CarPlate carPlate) {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        int current = (int) (timestamp.getTime()/1000);
        carPlate.setStuAddTimestamp(Integer.toString(current));
        carPlateMapper.addCarPlate(carPlate);
    }

    @Override
    public void editCarPlate(CarPlate carPlate) {

        carPlateMapper.editCarPlate(carPlate);
    }

    @Override
    public void deleteCarPlate(CarPlate carPlate) {

        carPlateMapper.deleteCarPlate(carPlate);

    }
}
