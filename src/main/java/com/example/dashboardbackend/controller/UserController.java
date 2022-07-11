package com.example.dashboardbackend.controller;

import com.example.dashboardbackend.bean.User;
import com.example.dashboardbackend.result.UserResult;
import com.example.dashboardbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/user/register")//@Validated
    @ResponseBody
    public UserResult register(@RequestBody User user) {
        String obj = userService.userRegister(user);
        if (obj.equals("Registration Successfully")) {
            return UserResult.success(obj);
        } else {
            return UserResult.failed(obj);
        }
    }

    @RequestMapping("/user/login")
    @ResponseBody
    public UserResult login(@RequestBody User user) {
        String ans = userService.userLogin(user);
        if (ans.equals("Username and Password are correct")) {
            return UserResult.success(ans);
        }
        return UserResult.failed(ans);
    }

    @RequestMapping("/user/updatePassword")
    @ResponseBody
    public UserResult updatePassword(@RequestBody User user) {
        String ans = userService.userLogin(user);
        if (ans.equals("Username and Password are correct")) {
            String rus = userService.updatePassword(user);
            if (rus.equals("Update Successfully")) {
                return UserResult.success(rus);
            }
            return UserResult.failed("rus");
        }
        return UserResult.failed(ans);
    }
}
