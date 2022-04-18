package com.example.dashboardbackend.result;

import com.example.dashboardbackend.bean.SystemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

// result class
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemStatusResult {
    private int code;
    private String msg;
    private Collection<SystemStatus> list;

    @Override
    public String toString() {
        return "{" +
                "code：" + code +
                ", msg：" + msg +
                ", msg：" + list +
                '}';
    }
}
