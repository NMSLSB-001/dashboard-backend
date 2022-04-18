package com.example.dashboardbackend.service.Impl;

import com.example.dashboardbackend.bean.CarPlate;
import com.example.dashboardbackend.mapper.CarPlateMapper;
import com.example.dashboardbackend.service.CarPlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Integer getCarPlateCount() {

        return carPlateMapper.getCarPlateCount();
    }

    @Override
    public void addCarPlate(CarPlate carPlate) {

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
