package cn.weiyupeng.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Create by weiyupeng on 2021/8/21 21:38
 * 功能：保存用户上一次访问的时间
 */
public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 服务器告诉你，你来的时间，把这个时间封装成一个信件，你下次来，就知道你来了

        // 解决中文乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        PrintWriter out = resp.getWriter();

        // Cookie，服务器端从客户端获取
        // 返回的是数组，说明 Cookie 可能存在多个
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName());
            System.out.println(cookie.getValue());
        }

        boolean hasCookie = false;
        // 判断想要的 Cookie 是否存在
        for (Cookie cookie : cookies) {
            // 获取 cookie 的名字
            if (cookie.getName().equals("name")) {
                hasCookie = true;

                // 获取 cookie 中的值
                String name = cookie.getValue();
                out.write("Hello ," + name + ", old friend !");
            }
        }

        // 如果不存在 Cookie
        if (!hasCookie) {
            out.write("Welcome ! This is the first time you visit !");

            // 服务器给客户端响应一个 Cookie
            Cookie cookie = new Cookie("name", "weiyupeng");
            resp.addCookie(cookie);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
