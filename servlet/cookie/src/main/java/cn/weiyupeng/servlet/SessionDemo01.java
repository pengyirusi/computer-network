package cn.weiyupeng.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Create by weiyupeng on 2021/8/22 10:08
 */
public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 得到 session
        HttpSession session = req.getSession();

        // 给 session 中存东西
        session.setAttribute("name", "weiyupeng");

        // 获取 session 的 ID
        String sessionId = session.getId();

        // 判断 session 是不是新创建的
        if (session.isNew()) {
            resp.getWriter().write("session created success, ID: " + sessionId);
        } else {
            resp.getWriter().write("session was existed, ID: " + sessionId);
        }

        session.removeAttribute("name");
        session.invalidate();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
