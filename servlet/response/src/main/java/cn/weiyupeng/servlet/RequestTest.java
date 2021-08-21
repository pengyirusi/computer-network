package cn.weiyupeng.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Create by weiyupeng on 2021/8/21 19:37
 */
public class RequestTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("enter doGet()");
        req.getContextPath();
        // 处理请求
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username + ": " + password);

        // 重定向时候一定要注意路径，否则 404
        resp.sendRedirect("/response_war_exploded/userProfile.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
