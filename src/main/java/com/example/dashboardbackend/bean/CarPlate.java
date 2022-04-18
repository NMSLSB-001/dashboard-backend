package com.example.dashboardbackend.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.TinyBitSet;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarPlate {
    private Integer stuIndex;
    private String studentId;
    private String studentName;
    private Integer isMale;
    private String studyYear;
    private String studyGroup;
    private String carPlateNum;


    @Override
    public String toString() {
        return "Student CarPlate：" +
                "Index=" + stuIndex +
                ", Id=" + studentId +
                ", StuName=" + studentName +
                ", Gender=" +  isMale +
                ", Year=" + studyYear +
                ", Group=" + studyGroup +
                ", CarPlate=" + carPlateNum +
                '}';
    }
}
