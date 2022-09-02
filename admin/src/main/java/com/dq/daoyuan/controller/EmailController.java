package com.dq.daoyuan.controller;

import com.alibaba.fastjson.JSON;
import com.dq.daoyuan.email.service.EmailService;
import com.dq.daoyuan.util.JSONResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("email")
public class EmailController {

    @Resource
    EmailService emailService;

    @PostMapping("requestCode")
    public JSONResult requestCode(@RequestBody Map toEmail , HttpSession session){
        Random r = new Random();
        int code = 1000 + r.nextInt(8999);
        session.setAttribute("emailCode" , code);
        boolean res = emailService.sendEmail(toEmail.get("toEmail").toString() , "道清途言-验证码" , code + "");
        if (res){
            return JSONResult.success("请接收验证码，避免过期" , null);
        }else{
            return JSONResult.error("请重新尝试或是重启浏览器，或是提交bug，通过后会给予物质补偿" , null);
        }
    }


    /**
     * 校验邮箱验证码
     * @param email
     * @return
     */
    public JSONResult checkEmailCode(@RequestBody Map email , HttpSession session){
        if (email.get("emailCode") == null){
            return JSONResult.error("邮箱验证码不能为空" , null);
        }

        if (session.getAttribute("emailCode") == null){
            return JSONResult.error("注册用户，请先申请注册验证码" , null);
        }
        String sessionEmailCode = session.getAttribute("emailCode").toString();
        String mapEmailCode = email.get("emailCode").toString();
        if (!mapEmailCode.equals(sessionEmailCode)){
            return JSONResult.error("验证身份失败" , null);
        }

        /** 验证码完全相同的情况下 */
        return JSONResult.build();
    }
}
