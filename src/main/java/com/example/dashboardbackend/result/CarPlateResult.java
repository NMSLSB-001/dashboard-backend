package com.example.dashboardbackend.result;

import com.example.dashboardbackend.bean.CarPlate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

// result class
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarPlateResult {
    private int code;
    private String msg;
    private Collection<CarPlate> list;
    private Integer total;

    @Override
    public String toString() {
        return "{" +
                "code：" + code +
                ", msg：" + msg +
                ", list：" + list +
                ", total：" + total+
                '}';
    }
}
