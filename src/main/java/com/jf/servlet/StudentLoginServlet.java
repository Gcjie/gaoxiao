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

@WebServlet(urlPatterns = "/StudentLoginServlet")
public class StudentLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // 获取前台提交的账号和密码
        String studentNum = request.getParameter("num");
        String studentPass = request.getParameter("stu-password");

//        System.out.println(applicantEmail+applicantPwd);

        // 根据账号和密码查询申请人
        StudentDao studentDao =new StudentDao();
        Student stu = new Student();
        try {
            stu=studentDao.selectStudentNumAndPass(studentNum,studentPass);
            if(stu!=null)
            {
                String num=stu.getNum();
//                System.out.println(num);
                request.getSession().setAttribute("SESSION_num",num);

                request.setAttribute("stu",stu);
                request.getRequestDispatcher("student.jsp").forward(request,response);
            }
            else {
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('学号或密码错误！');");
                writer.write("window.location.href = 'stu-login.html'");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
