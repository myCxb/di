package com.dq.daoyuan.email.service.impl;

import com.dq.daoyuan.email.service.EmailService;
import com.sun.net.httpserver.HttpsServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmailServiceImpl implements EmailService {

    @Resource
    private JavaMailSender javaM;

    @Value("${spring.mail.username}")
    private String fromEmail;


    /**
     * toEmail 接收验证码的邮箱
     * text 主题
     * message 主体信息
     *
     * @param toEmail
     * @param text
     * @param message
     */
    @Override
    public boolean sendEmail(String toEmail, String text, String message) {
        SimpleMailMessage mail = new SimpleMailMessage();
        /** 发送者邮箱账号，在配置文件中更改 */
        mail.setFrom(fromEmail);
        /** 收件人邮箱账号 */
        mail.setTo(toEmail);
        /** 邮件主题 */
        mail.setSubject(text);
        /** 内容 */
        mail.setText(message);
        /** 执行 */
        try {
            javaM.send(mail);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
