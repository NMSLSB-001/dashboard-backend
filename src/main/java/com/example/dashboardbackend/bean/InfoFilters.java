package com.example.dashboardbackend.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// filter class
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoFilters {
    private Integer current;
    private Integer size;
    private String empName;
    private String deptId;
}
