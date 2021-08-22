package cn.weiyupeng.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Create by weiyupeng on 2021/8/22 15:49
 */
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 获得初始化参数
        String site = filterConfig.getInitParameter("site");
        // 输出初始化参数
        System.out.println("site name: " + site);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 输出站点名称
        System.out.println("Request from weiyupeng.cn");

        // 把请求传回过滤链
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() { // 在 Filter 实例被 Web 容器从服务移除之前调用
        Filter.super.destroy();
    }
}
