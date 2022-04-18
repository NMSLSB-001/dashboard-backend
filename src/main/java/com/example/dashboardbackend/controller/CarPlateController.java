package com.example.dashboardbackend.controller;

import com.example.dashboardbackend.bean.CarPlate;
import com.example.dashboardbackend.result.CarPlateResult;
import com.example.dashboardbackend.service.CarPlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CarPlateController {

    //将Service注入web层
    @Autowired
    CarPlateService carPlateService;

    CarPlate carPlate;

    //Get Student CarPlate
    @RequestMapping("/api/getCarPlate")
    @ResponseBody
    public CarPlateResult getCarPlate(@RequestBody CarPlate carPlate){
        List<CarPlate> list = carPlateService.getCarPlate();
        Integer total = carPlateService.getCarPlateCount();
        CarPlateResult carPlateResult = new CarPlateResult(1000,"query successful!",list,total);
        System.out.println(carPlateResult);
        return carPlateResult;
    }

    //Add Student CarPlate
    @RequestMapping("/api/addCarPlate")
    @ResponseBody
    public CarPlateResult addCarPlate(@RequestBody CarPlate carPlate){
        carPlateService.addCarPlate(carPlate);
        CarPlateResult carPlateResult = new CarPlateResult(1000,"add successful!",null,null);
        return carPlateResult;
    }

    //Edit Student CarPlate
    @RequestMapping("/api/editCarPlate")
    @ResponseBody
    public CarPlateResult editCarPlate(@RequestBody CarPlate carPlate){
        carPlateService.editCarPlate(carPlate);
        CarPlateResult carPlateResult = new CarPlateResult(1000,"edit successful!",null,null);
        return carPlateResult;
    }

    //Delete Student CarPlate
    @RequestMapping("/api/deleteCarPlate")
    @ResponseBody
    public CarPlateResult deleteCarPlate(@RequestBody CarPlate carPlate){
        carPlateService.deleteCarPlate(carPlate);
        CarPlateResult carPlateResult = new CarPlateResult(1000," delete successful!",null,null);
        return carPlateResult;
    }

}
