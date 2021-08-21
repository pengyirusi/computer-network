package cn.weiyupeng.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Create by weiyupeng on 2021/8/21 14:36
 */
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.要下载文件的 path
        ServletContext context = this.getServletContext();
        String prefix = "Z:/IDEA Project/computer-network/servlet/response/target/classes/";
        String fileName = "qq.png";
        System.out.println("download path: " + prefix);

        // 2.想办法让浏览器支持下载我们需要的东西（这两个字符串为固定写法）
        resp.setHeader("Content-Disposition", "attachment;filename=" + fileName);

        // 3.获取下载文件的输入流
        FileInputStream in = new FileInputStream(prefix + fileName);

        // 4.创建缓冲区
        int len;
        byte[] buffer = new byte[1024];

        // 5.获取 OutPutStream 对象
        ServletOutputStream out = resp.getOutputStream();

        // 6.将 FileOutPutStream 写入到 buffer 缓，使用 OutPutStream 将缓冲区中的数据输出到客户端
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }

        // 7.关闭流
        in.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
