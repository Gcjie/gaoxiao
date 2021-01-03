package com.jf.servlet;

import com.jf.bean.Student;
import com.jf.dao.StudentDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String num = request.getParameter("stuNum");
        String name = request.getParameter("stuName");
        String sex = request.getParameter("stuSex");
        String major = request.getParameter("stuMajor");
        String stuClass = request.getParameter("stuClass");
        String password = request.getParameter("stuPassword");

//        System.out.println(num+name+sex+major+stuClass+password);
        Student student = new Student(num,name,sex,major,stuClass,password);

        StudentDao studentDao = new StudentDao();

        Integer count = studentDao.selectStu(num);
        if (count > 0) {
            // 数据库中已经有相同的用户
            // 通过response对象给客户端一个错误提示
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('用户已存在！');");
            writer.write("window.location.href = 'addStudent.html'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        } else {
            // flag是否添加成功
            boolean flag = studentDao.saveStudent(student);

            if (flag) {
                // 添加成功就返回到页面   重定向
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('添加成功！');");
                writer.write("window.location.href = 'addStudent.html'");
                writer.write("</script>");
                writer.flush();
                writer.close();
            } else {
                // 注册失败就返回注册页面   请求转发
                RequestDispatcher dispatcher = request.getRequestDispatcher("addStudent.html");
                dispatcher.forward(request, response);
            }
        }
    }
}
