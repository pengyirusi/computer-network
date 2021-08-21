package cn.weiyupeng.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

/**
 * Create by weiyupeng on 2021/8/21 15:19
 */
public class ImageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 如何让浏览器 5 秒自动刷新一次
        resp.setHeader("refresh","3");

        // 在内存中创建一个图片
        BufferedImage image = new BufferedImage(100, 20, BufferedImage.TYPE_INT_RGB);
        // 得到图片
        Graphics g = (Graphics2D)image.getGraphics(); // 笔
        // 设置背景颜色
        g.setColor(Color.white);
        g.fillRect(0, 0, 100, 20);
        // 给图片写数据
        g.setColor(Color.blue);
        g.setFont(new Font(null,Font.BOLD, 20));
        g.drawString(makeNum(), 0, 20);

        // 告诉浏览器这个请求用图片的方式打开
        resp.setContentType("image/jpg");
        // 网站存在缓存，不让它缓存
        resp.setDateHeader("Expires", -1);
        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("Pragma", "no-cache");

        // 把图片写给浏览器
        ImageIO.write(image, "jpg", resp.getOutputStream());

    }

    // 生成随机的 8 位数，前面用 0 补齐
    private String makeNum() {
        Random random = new Random();
        String num = random.nextInt(99999999) + "";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 8 - num.length(); i++) {
            sb.append("0");
        }
        num = sb.append(num).toString();
        return num;
    }
}
