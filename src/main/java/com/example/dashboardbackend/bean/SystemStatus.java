package com.example.dashboardbackend.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemStatus {
    private Integer statusIndex;
    private Integer serviceId;
    private Integer isDetSerRunning;
    private Integer isDaProRunning;
    private String detSerIP;
    private String detSerMAC;
}
