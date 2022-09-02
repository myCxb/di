package com.dq.daoyuan.admin.service.impl;

import com.alibaba.fastjson.JSON;
import com.dq.daoyuan.admin.dao.DyAdminUserDao;
import com.dq.daoyuan.admin.entity.DyAdminUser;
import com.dq.daoyuan.admin.service.DyAdminUserService;
import com.dq.daoyuan.util.JSONResult;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * (DyAdminUser)表服务实现类
 *
 * @author makejava
 * @since 2022-08-31 00:32:59
 */
@Service("dyAdminUserService")
public class DyAdminUserServiceImpl implements DyAdminUserService {
    @Resource
    private DyAdminUserDao dyAdminUserDao;

    /**
     * login（登录业务逻辑）
     * 登录业务，传送一个map的参数
     * 包含唯一账户名、密码、验证码
     * @param params
     * @return
     */
    @Override
    public JSONResult login(Map params , HttpSession session) {
        if (params.get("uuid") == null){
            return JSONResult.error("唯一标识符存在异常" , null);
        }

        if (params.get("password") == null){
            return JSONResult.error("密码存在异常" , null);
        }

        if (params.get("VCode") == null){
            return JSONResult.error("验证码存在异常" , null);
        }

        String uuid = params.get("uuid").toString();

        if (uuid.length() >= 25 && uuid.length() <= 6){
            return JSONResult.error("唯一标识符存在异常" , null);
        }

        String password = params.get("password").toString();
        if (password.length() < 6 || password.length() > 25){
            return JSONResult.error("密码存在异常" , null);
        }

        String vCode = params.get("VCode").toString();
        if (vCode.length() != 4){
            return JSONResult.error("验证码存在异常" , null);
        }


        String code = session.getAttribute("code").toString();
        System.out.println(code);
        System.out.println(vCode);
        if (!vCode.equals(code)){
            return JSONResult.error("验证码错误或是失效，请重新刷新获取" , null);
        }


        /** 验证码正确，密码与唯一账户名不存在异常情况下，执行一下代码块 */
        try {
            List<DyAdminUser> list = dyAdminUserDao.query(uuid , password , 0);

            if (list.size() == 0){
                List<DyAdminUser> userList = dyAdminUserDao.query(uuid , password , 1);
                if (userList.size() == 1){
                    return JSONResult.empty("账号冻结中");
                }
                return JSONResult.empty("账号或是密码错误，未找到该用户!");

            }else if (list.size() == 1){
                DyAdminUser user = list.get(0);
                StringBuffer massage = new StringBuffer();
                try {
                    massage.append("您好，");
                    massage.append(user.getRealName());
                    int lastTime = user.getUserLastLoginTime();
                    int currentTime = (int) (System.currentTimeMillis() / 1000);
                    int time = (currentTime - lastTime) / 1000 / 60 / 60 / 24;
                    if (time > 1){
                        massage.append(",时隔" + time + "天");
                    }
                    massage.append(",我们又见面了。");
                } catch (Exception e){
                    massage.append("您好" + user.getRealName());
                }

                /** 修改最近登录时间 */
                /** user_last_login_time（用户上次登录时间） 由 上次的user_this_login_time（用户这次登录时间）决定
                 *  user_this_login_time由当前时间决定
                 */
                try {
                    dyAdminUserDao.updateLoginTime(user.getUserId() , user.getUserThisLoginTime() , (int)(System.currentTimeMillis() / 1000) );
                } catch (Exception e){
                    e.printStackTrace();
                }
                return JSONResult.success(massage.toString() , user);
            } else if (list.size() > 1){
                /** 查询出该此条件查询下的所有账号，该条件下的所有账号都存在异常 */
            }
        } catch (Exception e){
            e.printStackTrace();
            return JSONResult.error("系统出错，你稍等重试" , null);
        }
        return JSONResult.build();
    }


    /**
     * 注册业务
     * params 包含的内容皆是用户需要自定义的信息
     * 1.email ： 邮箱
     * 2.phoneNumbers 手机号
     * 3.password 密码
     * 他（她，它）会通过前端响应，以邮箱或是手机号进行注册，密码是必填项目
     * @param params
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public JSONResult registered(Map params , HttpSession session) {
        try {
            /** 非空判断 */
            /** 邮箱或是手机号存在一个不为空就放行，否者便是前端传来的数据存在错误 */
            boolean bl = false;

            if (params.get("phoneNumbers") != null){
                bl = true;
            }

            if (params.get("email") != null){
                bl = true;
            }

            if (!bl){
                return JSONResult.error("请输入邮箱或是手机号" , null);
            }

            if (params.get("password") == null){
                return JSONResult.error("密码不为空" , null);
            }

            String password = params.get("password").toString();
            if (password.length() < 6 || password.length() > 15){
                return JSONResult.error("密码异常" , null);
            }

            String email = params.get("email").toString();
            if (session.getAttribute("emailCOde") == null){
                return JSONResult.error("请先请求邮箱验证码" ,null);
            }

            if (!session.getAttribute("emailCode").equals(email)){
                return JSONResult.error("邮箱异常" ,null);
            }

            /** 执行注册的业务 */

//        DyAdminUser user = new DyAdminUser();
            String uuid = "";
            Random r = new Random();
            StringBuffer userName = new StringBuffer("dao_");
            for (int i = 0 ; i < 5 ; i++){
                char chas = (char) (r.nextInt(97) + 26);
                userName.append(chas);
            }
            int time = Integer.parseInt(System.currentTimeMillis() / 1000 + "");
            int resCode = dyAdminUserDao.addUser(uuid , userName.toString() , "" , "" , password , time);
            if (resCode == 1){
                /** 基本流程算成功，数据库理应存在此数据 */
                /** 目前业务下，需要再给他返回一个uuid */

                List<DyAdminUser> list = dyAdminUserDao.byUUid("" , "");
//            if (list.size() == 1){
                return JSONResult.success("注册成功" , list);
//            }
            }
            return null;
        } catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return JSONResult.error("错误" , null);
        }

    }
}
