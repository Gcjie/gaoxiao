package com.jf.servlet;

import com.jf.bean.Student;
import com.jf.dao.AdminDao;
import com.jf.dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        // 获取前台提交的账号和密码
        String username = request.getParameter("username");
        String password = request.getParameter("adm-password");
//        System.out.println(applicantEmail+applicantPwd);

        // 根据账号和密码查询用户
        AdminDao adminDao =new AdminDao();
        StudentDao studentDao =new StudentDao();
        boolean pass;
        try {
            pass=adminDao.selectAdminNameAndPass(username,password);
            List<Student> students = studentDao.selectStudent();
            if(pass==true)
            {
                request.setAttribute("student",students);
//                System.out.println(students);
                request.getRequestDispatcher("adm-main.jsp").forward(request,response);
            }
            else {
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('用户名或密码错误！');");
                writer.write("window.location.href = 'adm-login.html'");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
