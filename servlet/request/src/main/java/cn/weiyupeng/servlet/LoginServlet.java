package cn.weiyupeng.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Create by weiyupeng on 2021/8/21 20:19
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username + " ~ " + password);

        // 通过请求转发
        /*if ("weiyupeng".equals(username)) {
            req.getRequestDispatcher("/success.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }*/

        // 重定向
        if ("weiyupeng".equals(username)) {
            resp.sendRedirect(req.getContextPath() + "/success.jsp");
        } else {
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }


    }
}
