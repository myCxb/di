package com.dq.daoyuan.controller;

import com.dq.daoyuan.util.GraphicHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@RequestMapping("graphic")
public class GraphicController{

    @GetMapping("VerificationCode")
    public void VerificationCode (HttpSession session , HttpServletResponse response) throws IOException {

        /** 宽高设置 **/
        final int width = 120;
        final int height = 40;
        final String imgType = "jpeg";
        final OutputStream output = response.getOutputStream();

        String msg = GraphicHelper.VerificationCode(width ,height ,imgType ,output);
        /** 存于session中 **/
        session.setAttribute("code" , msg);
        System.out.println(session.getAttribute("code"));
    }

}
