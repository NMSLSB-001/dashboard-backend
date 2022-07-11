package com.example.dashboardbackend.bean;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
// @EqualsAndHashCode(callSuper = false)
public class User {// implements Serializable {

    // private static final long serialVersionUID=1L;
    // @TableId(value = "id", type = IdType.AUTO)
    private Integer userId;
    private String username;
    private String userPassword;
    private String newPassword;
    // @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    // @TableField(fill = FieldFill. INSERT_UPDATE)
    private Date updateTime;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return userPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

