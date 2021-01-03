package com.jf.servlet;

import com.jf.bean.Admin;
import com.jf.dao.AdminDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/AdminRegisterServlet")
public class AdminRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // 获取前台提交的账号和密码
        String username = request.getParameter("username");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");

        if(username.equals("")||password1.equals("")||password2.equals("")){
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('用户名/密码不能为空！');");
            writer.write("window.location.href = 'adm-register.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }

        if(!password1.equals(password2)){
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('密码不正确，请重新输入！');");
            writer.write("window.location.href = 'adm-register.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }
        // 插入到数据库中，对数据进行封装, 自己封装成一个对象
        Admin admin = new Admin(null, username, password1);

        // 保存adminDao到数据库  AdminDao
        AdminDao adminDao = new AdminDao();

        // 判断是否有相同的用户
        Integer count = adminDao.selectAdminNameCount(username);
        if (count > 0) {
            // 数据库中已经有相同的用户
            // 通过response对象给客户端一个错误提示
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('用户已存在！');");
            writer.write("window.location.href = 'adm-register.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        } else {
            // flag是否注册成功
            boolean flag = adminDao.saveAdmin(admin);

            if (flag) {
                // 注册成功就跳转到登录页面   重定向
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('注册成功！');");
                writer.write("window.location.href = 'adm-login.html'");
                writer.write("</script>");
                writer.flush();
                writer.close();
            } else {
                // 注册失败就返回注册页面   请求转发
                RequestDispatcher dispatcher = request.getRequestDispatcher("adm-register.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
}
