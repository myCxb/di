package com.dq.daoyuan.admin.service;


import com.dq.daoyuan.util.JSONResult;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * (DyAdminUser)表服务接口
 *
 * @author makejava
 * @since 2022-08-31 00:32:58
 */
public interface DyAdminUserService {


    /**
     * login（登录业务逻辑）
     * @param params
     * @return
     */
    JSONResult login(Map params , HttpSession session);

    /**
     * 注册业务
     * @param params
     * @return
     */
    JSONResult registered(Map params , HttpSession session);


}
