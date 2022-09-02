package com.dq.daoyuan.admin.entity;

import java.io.Serializable;

/**
 * (DyAdminUser)实体类
 *
 * @author makejava
 * @since 2022-08-31 02:12:44
 */
public class DyAdminUser implements Serializable {
    private static final long serialVersionUID = -21537306061305500L;
    /**
     * 用户唯一标识
     */
    private Integer userId;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 真实名字，不可修改
     */
    private String realName;
    /**
     * 用户密码
     */
    private String userPassword;
    /**
     * 删除标记
     */
    private Integer del;
    /**
     * uuid
     */
    private String userUuid;
    /**
     * 手机号码
     */
    private String phoneNumbers;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 用户上次登录时间
     */
    private Integer userLastLoginTime;
    /**
     * 用户这次登录时间
     */
    private Integer userThisLoginTime;
    /**
     * 用户注册时间
     */
    private Integer userAddTime;
    /**
     * 用户注销时间
     */
    private Integer userDelTime;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUserLastLoginTime() {
        return userLastLoginTime;
    }

    public void setUserLastLoginTime(Integer userLastLoginTime) {
        this.userLastLoginTime = userLastLoginTime;
    }

    public Integer getUserThisLoginTime() {
        return userThisLoginTime;
    }

    public void setUserThisLoginTime(Integer userThisLoginTime) {
        this.userThisLoginTime = userThisLoginTime;
    }

    public Integer getUserAddTime() {
        return userAddTime;
    }

    public void setUserAddTime(Integer userAddTime) {
        this.userAddTime = userAddTime;
    }

    public Integer getUserDelTime() {
        return userDelTime;
    }

    public void setUserDelTime(Integer userDelTime) {
        this.userDelTime = userDelTime;
    }

}

