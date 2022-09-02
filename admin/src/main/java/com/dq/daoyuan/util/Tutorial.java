package com.dq.daoyuan.util;

import netscape.security.UserTarget;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.omg.CORBA.portable.UnknownException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tutorial {

    private static final  transient Logger log = LoggerFactory.getLogger(Tutorial.class);

    public static void main(String[] args) {
        log.info("My First Apache Shiro Application");
//        System.exit(0);

        /** 加载配置文件 */
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");


        /** 解析文件，并返回一些实例 */
        SecurityManager sm = factory.getInstance();

        /** 设置到静态内存内 */
        SecurityUtils.setSecurityManager(sm);

        //安全操作
        Subject subject = SecurityUtils.getSubject();

        //在应用的当前会话中设置属性
        Session session = subject.getSession();
        session.setAttribute("key" , "value");

        //当前我们的用户是匿名用户，尝试进行登录
        if (!subject.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken("aihe" , "aihe");

            token.setRememberMe(true);

            //尝试进行登录，如果登录失败，执行以下操作
            try {
                subject.login(token);
                //获取我们当前登录用户之后
                log.info("User[" + subject.getPrincipal() + "] logged in successfully");

                //查看用户是否是指定的角色
                if (subject.hasRole("client")){
                    log.info("look is in your role");
                } else{
                    log.info("……");
                }
                //查看用户是否有这个权限
                if (subject.isPermitted("look:desk")){
                    log.info("You can look. Use it Wisely");
                } else {
                    log.info("Sorry, you can't look.");
                }

                if (subject.isPermitted("winnebago:derive:eagle5")){
                    log.info("You are permitted to 'drive' the 'winnebago' with license plate (id) 'eagle5'.  " +
                            "Here are the keys - have fun!");
                } else{
                    log.info("Sorry, you aren't allowed to drive the 'eagle5' winnebago!");
                }

                //登出
                subject.logout();
            } catch (UnknownException e){
                System.out.println("账号不存在");

            } catch (IncorrectCredentialsException e){
                System.out.println("密码不正确");

            } catch (LockedAccountException e){
                System.out.println("用户被锁定");

            }  catch (AuthenticationException e){
                System.out.println("无法判断的错误");
            }
        }
        System.exit(0);
    }

}
