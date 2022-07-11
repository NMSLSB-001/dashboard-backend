package com.example.dashboardbackend.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginSession {

    private Integer userId;
    private String sessionToken;
    private String sessionStart;
    private String sessionEnd;
}
