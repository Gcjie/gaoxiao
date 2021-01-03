package com.jf.servlet;

import com.jf.dao.StudentDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String num = (String) request.getSession().getAttribute("SESSION_stuNum");
        String name = request.getParameter("stuName");
        String sex = request.getParameter("stuSex");
        String major = request.getParameter("stuMajor");
        String stuClass = request.getParameter("stuClass");
        String password = request.getParameter("stuPassword");

        StudentDao studentDao = new StudentDao();

        boolean pass;
        try {
            pass=studentDao.updateStudent(num,name,sex,major,stuClass,password);
            if (pass) {
                // 添加成功就返回到页面   重定向
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('修改成功！');");
                writer.write("window.location.href = 'updateStudent.jsp'");
                writer.write("</script>");
                writer.flush();
                writer.close();
            } else {
                // 注册失败就返回注册页面   请求转发
                RequestDispatcher dispatcher = request.getRequestDispatcher("updateStudent.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
