package com.example.dashboardbackend.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataHistory {
    private Integer historyIndex;
    private String detTimestamp;
    private String detCarPlate;
    private String detConfidence;
    private String detStudentName;
    private String detStudentClass;
    private String detImageLink;



    @Override
    public String toString() {
        return "Student CarPlate：" +
                "Index=" + historyIndex +
                "Timestamp" + detTimestamp +
                "CarPlate" + detCarPlate +
                "Confidence" + detConfidence +
                "StudentName" + detStudentName +
                "StudentClass" + detStudentClass +
                "ImageLink" + detImageLink +
                '}';
    }
}
