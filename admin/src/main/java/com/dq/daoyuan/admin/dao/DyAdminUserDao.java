package com.dq.daoyuan.admin.dao;


import com.dq.daoyuan.admin.entity.DyAdminUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (DyAdminUser)表数据库访问层
 *
 * @author makejava
 * @since 2022-08-31 00:32:56
 */
@Mapper
public interface DyAdminUserDao {

    /**
     * 查询
     * @param userUuid
     * @param password
     * @param del
     * @return
     */
    List<DyAdminUser> query(@Param("userUuid") String userUuid , @Param("password") String password , @Param("del") Integer del);

    /**
     * 登录的业务中
     * 将上次登录时间与这次登录时间进行修改
     * @param userId
     * @param lastTime
     * @param thisTime
     * @return
     */
    Integer updateLoginTime(@Param("userId") Integer userId , @Param("userLastLoginTime") Integer lastTime , @Param("userThisLoginTime") Integer thisTime);


    /**
     * 添加用户
     * @param uuid         唯一编号
     * @param userName     用户名
     * @param email        邮箱
     * @param phoneNumbers 手机号
     * @param password     密码
     * @param userAddTime  注册时间
     * @return
     */
    Integer addUser(@Param("uuid") String uuid ,@Param("userName") String userName ,@Param("email") String email ,@Param("phoneNumbers") String phoneNumbers ,@Param("password") String password , @Param("userAddTime") Integer userAddTime);


    /**
     * 查询该条件下的用户uuid
     * 邮箱与手机号皆是字段唯一标识
     * @param email           邮箱
     * @param phoneNumbers    手机号
     * @return
     */
    List<DyAdminUser> byUUid(@Param("email") String email ,@Param("phoneNumbers") String phoneNumbers);
}

