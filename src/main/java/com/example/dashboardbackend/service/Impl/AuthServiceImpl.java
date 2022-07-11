package com.example.dashboardbackend.service.Impl;

import com.example.dashboardbackend.bean.Auth;
import com.example.dashboardbackend.bean.User;
import com.example.dashboardbackend.mapper.AuthMapper;
import com.example.dashboardbackend.service.AuthService;
import com.example.dashboardbackend.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    AuthMapper authMapper;

    private final static int EXPIRE = 24;

    @Override
    public Integer getUserIdByUsername(String username) {
        return authMapper.getUserIdByUsername(username);
    }

    public String isUsernameTrue(String username) {

        if (username == null || username.equals("")) {
            return "Username cannot be empty";
        }
        if (username.length() > 10 || username.length() < 3) {
            return "Username length can only within 3~10 characters";
        }
        if (isSpecialChar(username)) {
            return "Username contains special characters";
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
    public String userLogin(User user) {

        String usernameAns = isUsernameTrue(user.getUsername());
        String passwordAns = isPasswordTrue(user.getPassword());
        if(!usernameAns.equals("OK")) {
            return usernameAns;
        }
        if(!passwordAns.equals("OK")) {
            return passwordAns;
        }
        String passwordResult = authMapper.getPasswordByUsername(user.getUsername());
        if (passwordResult == null) {
            return "Username Error";
        } else if (passwordResult.equals(MD5Utils.code(user.getPassword()))) {
            return "Username and Password are correct";
        }
        return "Password Error";

        /**
        String pd = authMapper.getPasswordByUsername(user.getUsername());
        if (pd == null) {
            return "Username Error";
        } else if (pd.equals(MD5Utils.code(user.getPassword()))) {
            return "Username and Password are correct";
        }
        return "Password Error";
         **/
    }

    @Override
    public String createToken(Integer userId) {
        Auth auth = new Auth();
        auth.setUserId(userId);
        //用UUID生成token
        String token = UUID.randomUUID().toString();
        //当前时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Now create LocalDateTime: " + now.toString());
        Date createDate = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("Now create Date: " + createDate.toString());
        //过期时间
        LocalDateTime expireTime = now.plusHours(EXPIRE);
        //保存到数据库
        auth.setLoginTime(now.withNano(0));
        auth.setExpiryTime(expireTime.withNano(0));
        auth.setAuthToken(token);
        authUpdate(auth);
        return token;
    }

    @Override
    public void authUpdate(Auth auth) {
        authMapper.authUpdate(auth);
    }

    @Override
    public LocalDateTime getExpiryTime(String authToken) {
        Date date = authMapper.getExpiryTime(authToken);
        if (date != null) {
            System.out.println("ExpiryDate: " + date);
            LocalDateTime expiryDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            System.out.println("ExpiryLocalDateTime: " + expiryDate);
            return expiryDate;
        }
        LocalDateTime beginLocalDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(Long.parseLong("0")), ZoneId.systemDefault());
        System.out.println("BeginLocalDateTime: " + beginLocalDateTime);
        return beginLocalDateTime;
    }

    @Override
    public boolean checkToken(String authToken) {

        if (authMapper.checkToken(authToken) != null) {
            LocalDateTime expiryLocalDateTime = getExpiryTime(authToken);
            if (LocalDateTime.now().isBefore(expiryLocalDateTime)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public void userLogout(String authToken) {
        authMapper.authDelete(authToken);
    }
}
