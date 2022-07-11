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
    private Integer userId;
    private String studentName;
    private Integer isMale;
    private String studyYear;
    private String studyGroup;
    private String carPlateNum;
    private String stuAddTimestamp;


    @Override
    public String toString() {
        return "Student CarPlate：" +
                "Index=" + stuIndex +
                ", Id=" + studentId +
                ", UserId=" + userId +
                ", StuName=" + studentName +
                ", Gender=" + isMale +
                ", Year=" + studyYear +
                ", Group=" + studyGroup +
                ", CarPlate=" + carPlateNum +
                ", StuAddTimestamp=" + stuAddTimestamp +
                '}';
    }

    public void setStuAddTimestamp(String stuAddTimestamp) {
        this.stuAddTimestamp = stuAddTimestamp;
    }
}
