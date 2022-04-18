package com.example.dashboardbackend.mapper;

import com.example.dashboardbackend.bean.CarPlate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarPlateMapper {

    // get all car plate
    public List<CarPlate> getCarPlate();

    // get count
    public Integer getCarPlateCount();

    // add
    public void addCarPlate(CarPlate carPlate);

    // edit
    public void editCarPlate(CarPlate carPlate);

    // delete
    public void deleteCarPlate(CarPlate carPlate);
}
