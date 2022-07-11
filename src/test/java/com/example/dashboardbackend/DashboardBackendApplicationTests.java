package com.example.dashboardbackend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@SpringBootTest
class DashboardBackendApplicationTests {

    @Test
    void contextLoads() {

        Date date = new Date();
        LocalDateTime now = LocalDateTime.now();
        now = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println(now);
    }

}
