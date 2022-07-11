package com.example.dashboardbackend.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataPaginationResult {
    private int code;
    private String msg;
    private List<?> list;
    private int pageNum;
    private int pageSize;
    private long totalSize;
    private int totalPages;

    @Override
    public String toString() {
        return "{" +
                "code：" + code +
                ", msg：" + msg +
                ", list：" + list +
                ", pageNum：" + pageNum +
                ", pageSize：" + pageSize +
                ", totalSize：" + totalSize +
                ", totalPages：" + totalPages +
                '}';
    }
}
