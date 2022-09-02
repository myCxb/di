package com.dq.daoyuan.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Random;

/**
 * 后台图形生成代码
 */
public class GraphicHelper {

    /**
     *
     * @param width    图形宽度
     * @param height   图形高度
     * @param imgType  图片类型
     * @param output   输出流
     * @return String  验证码文本信息
     */
    public static String VerificationCode(final int width , final int height , final String imgType , OutputStream output){
        /** 随机数生成器 **/
        Random random = new Random();
        /** 存放图片内容上的文本信息 **/
        StringBuffer buffer = new StringBuffer();

        BufferedImage image = new BufferedImage(width , height , BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();

        /** 默认给予背景色F8F8F8（灰白色） **/
        graphics.setColor(Color.getColor("F8F8F8"));
        /** 斜对角占用皆为img的大小区域 **/
        graphics.fillRect(0 , 0 , width , height);

        /** 默认字体颜色在此数组中随机产出 **/
        Color[] colors = new Color[]{ Color.BLUE, Color.GRAY, Color.GREEN, Color.RED, Color.BLACK, Color.ORANGE,
                Color.CYAN };

        /** 在画板上生成50个干扰线 **/
        for (int i = 0 ; i < 20 ; i ++){
           graphics.setColor(colors[random.nextInt(colors.length)]);
           final int x = random.nextInt(width);
           final int y = random.nextInt(height);
           final int w = random.nextInt(20);
           final int h = random.nextInt(20);
           final int sigA = random.nextBoolean() ? 1 : -1;
           final int sigB = random.nextBoolean() ? 1 : -1;
           graphics.drawLine(x , y , w + h * sigA , y + h * sigB);
        }

        /** 绘制字母，默认6位 **/
        graphics.setFont(new Font("Comic Sans MS" , Font.BOLD , 30 ));
        for (int  i = 0 ; i < 4 ; i++){
            final int index = random.nextInt(26) + 97;
            String str = String.valueOf((char)index);
            buffer.append(str);
            graphics.setColor(colors[random.nextInt(colors.length)]);
            graphics.drawString(str , i * (width / 4) , height - height / 3);
        }

        graphics.dispose();

        try {
            ImageIO.write(image , imgType ,  output);
        } catch (Exception e){
            e.printStackTrace();
        }
        return buffer.toString();
    }



}
