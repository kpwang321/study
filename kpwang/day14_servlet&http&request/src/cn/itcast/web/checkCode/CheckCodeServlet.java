package cn.itcast.web.checkCode;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * @author kpwang
 * @create 2020-07-03 0:59
 */
@WebServlet("/checkCode")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width=100;
        int height=50;
        //1创建一对象，在内存中图片(验证码图片对象)
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //2美化图片
        Graphics  g= image.getGraphics();//画笔对象
        g.setColor(Color.PINK);
        g.fillRect(0,0,width,height);
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width-1,height-1);

        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random=new Random();
        for (int i = 0; i <4 ; i++) {
            int index = random.nextInt(str.length());
            char ch = str.charAt(index);
            g.drawString(String.valueOf(ch),width/5*(i+1),height/2);
        }
        //划干扰线
        g.setColor(Color.GREEN);
        for (int i = 0; i <10 ; i++) {
            int x1=random.nextInt(width);
            int y1=random.nextInt(height);
            int x2=random.nextInt(width);
            int y2=random.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }



        //3将图片输出到页面
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(image,"jpg",response.getOutputStream());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
