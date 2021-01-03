package com.jf.servlet;

import com.jf.bean.Student;
import com.jf.dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/DelStudentServlet")
public class DelStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String num = request.getParameter("stuNum");
        StudentDao studentDao = new StudentDao();

        studentDao.delStudent(num);
//        System.out.println(del);
        List<Student> students = null;
        try {
            students = studentDao.selectStudent();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("student", students);
        request.getRequestDispatcher("adm-main.jsp").forward(request, response);
    }
}
