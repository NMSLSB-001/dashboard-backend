package com.example.dashboardbackend.service.Impl;

import com.example.dashboardbackend.bean.User;
import com.example.dashboardbackend.mapper.UserMapper;
import com.example.dashboardbackend.service.UserService;
import com.example.dashboardbackend.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public String userRegister(User user) {

        String usernameAns = isUsernameTrue(user.getUsername());
        if (usernameAns.equals("OK")) {
            String passwordAns = isPasswordTrue(user.getPassword());
            if (passwordAns.equals("OK")) {
                user.setPassword(MD5Utils.code(user.getPassword()));
                Date date = new Date();
                user.setCreateTime(date);
                user.setUpdateTime(date);
                userMapper.userRegister(user);
                return "Registration Successfully";
            }
            return passwordAns;
        }
        return usernameAns;
    }


    @Override
    public String userLogin(User user) {
        String passwordAns = isPasswordTrue(user.getPassword());
        if (!passwordAns.equals("OK")) {
            return passwordAns;
        }
        String passwordResult = userMapper.selectPasswordByUsername(user.getUsername());
        if (passwordResult == null) {
            return "Username Error";
        } else if (passwordResult.equals(MD5Utils.code(user.getPassword()))) {
            return "Username and Password are correct";
        }
        return "Password Error";
    }

    public String isUsernameTrue(String username) {

        if (username == null || username.equals("")) {
            return "Username cannot be empty";
        }
        if (userMapper.selectByUsername(username) != null) {
            return "Username already existing";
        }
        if (username.length() > 10 || username.length() < 3) {
            return "Username length can only within 3~10 characters";
        }
        return "OK";
    }

    public String isPasswordTrue(String password) {

        if (password == null || password.equals("")) {
            return "Password cannot be empty";
        }
        if (password.length() > 16 || password.length() < 4) {
            return "Password length can only within 4~16 characters";
        }
        if (isSpecialChar(password)) {
            return "Password contains special characters";
        }
        return "OK";
    }

    public static boolean isSpecialChar(String str) {
        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }

    @Override
    public String updatePassword(User user) {

        String passwordAns = isPasswordTrue(user.getPassword());
        if (!passwordAns.equals("OK")) {
            return passwordAns;
        }
        if (!user.getPassword().equals(user.getNewPassword())) {
            String password = isPasswordTrue(user.getPassword());
            String newPassword = isPasswordTrue(user.getNewPassword());
            if (password.equals("OK") || newPassword.equals("OK")) {
                user.setPassword(MD5Utils.code(user.getNewPassword()));
                Date date = new Date();
                user.setUpdateTime(date);
                userMapper.updatePassword(user);
                return "Update Successfully";
            }
            return password + " " + newPassword;
        }
        return "New password should not be same as current one";
    }
}


