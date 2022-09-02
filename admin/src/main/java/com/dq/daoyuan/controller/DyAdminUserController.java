package com.dq.daoyuan.controller;

import com.dq.daoyuan.admin.service.DyAdminUserService;
import com.dq.daoyuan.util.JSONResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * (DyAdminUser)表控制层
 *
 * @author makejava
 * @since 2022-08-31 00:32:54
 */
@RestController
@RequestMapping("dyAdminUser")
public class DyAdminUserController {
    /**
     * 服务对象
     */
    @Resource
    private DyAdminUserService dyAdminUserService;

    @PostMapping("login")
    public JSONResult login(@RequestBody Map params , HttpSession session){
        return dyAdminUserService.login(params , session);
    }

    @PostMapping("registered")
    public JSONResult registered(@RequestBody Map params ,HttpSession session){
        return dyAdminUserService.registered(params , session);
    }

}

