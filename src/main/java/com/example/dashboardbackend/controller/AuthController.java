package com.example.dashboardbackend.controller;

import com.example.dashboardbackend.bean.User;
import com.example.dashboardbackend.result.UserResult;
import com.example.dashboardbackend.service.AuthService;
import com.example.dashboardbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    AuthService authService;

    @RequestMapping("/user/userLogin")
    @ResponseBody
    public UserResult userLogin(@RequestBody User user) {
        String ans = authService.userLogin(user);
        if(ans.equals("Username and Password are correct")){
            Integer id = authService.getUserIdByUsername(user.getUsername());
            String token = authService.createToken(id);
            return UserResult.success(token);
        }
        return UserResult.failed(ans);
    }

    @RequestMapping("/user/isStillValid")
    @ResponseBody
    public UserResult isStillValid(@RequestParam(value="authToken") String authToken) {
        if (authService.checkToken(authToken)) {
            return UserResult.success("1");
        } else {
            return UserResult.failed("0");
        }
    }

    @RequestMapping("/user/userLogout")
    @ResponseBody
    public UserResult userLogout(@RequestParam(value="authToken") String authToken) {
        if (authService.checkToken(authToken)) {
            authService.userLogout(authToken);
            return UserResult.success("Logout Successfully");
        } else {
            return UserResult.failed("Logout Failed");
        }

    }
}
