package cn.weiyupeng.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Create by weiyupeng on 2021/8/21 9:59
 */
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // this.getInitParameter(); // 初始化参数
        // this.getServletConfig(); // Servlet 配置
        // this.getServletContext(); // 上下文
        // this.getInitParameterNames(); // 参数名
        ServletContext servletContext = this.getServletContext();
        String userName = "weiyupeng"; // 数据对象
        // 将数据以 kv 的形式保存在 ServletContext
        servletContext.setAttribute("userName", userName);


        System.out.println("Hello");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
