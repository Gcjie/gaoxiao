package com.jf.servlet;

import com.jf.bean.Student;
import com.jf.dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/SelectStudentServlet")
public class SelectStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String num = request.getParameter("stuNum");
        StudentDao studentDao = new StudentDao();
        try {
            List<Student> students = studentDao.selectNum(num);
//            System.out.println(students);
            if(students.size()!=0)
            {
                request.setAttribute("student",students);
                request.getRequestDispatcher("adm-main.jsp").forward(request,response);
            }
            else if(num.equals("")){
                List<Student> stu = null;
                stu=studentDao.selectStudent();
                request.setAttribute("student", stu);
                request.getRequestDispatcher("adm-main.jsp").forward(request, response);
            }
            else {
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('学号不存在！');");
                writer.write("window.location.href = 'adm-main.jsp'");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
