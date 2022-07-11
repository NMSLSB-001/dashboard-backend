package com.example.dashboardbackend.result;

import com.example.dashboardbackend.bean.CarPlate;
import com.example.dashboardbackend.bean.DataHistory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

// result class
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataHistoryResult {
    private int code;
    private String msg;
    private Collection<DataHistory> list;
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
