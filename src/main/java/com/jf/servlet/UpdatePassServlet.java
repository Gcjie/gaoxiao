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

@WebServlet(urlPatterns = "/UpdatePassServlet")
public class UpdatePassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String oldPass = request.getParameter("oldPass");
        String newPass = request.getParameter("newPass");

        String num= (String)request.getSession().getAttribute("SESSION_num");
//        System.out.println(num);
        StudentDao studentDao = new StudentDao();
        Student student = new Student();
        try {
            student=studentDao.selectStudentNumAndPass(num,oldPass);
            if(student.getPassword().equals(oldPass)){
                boolean pass;
                pass=studentDao.updatePass(newPass,num);
                if(pass==true){
                    PrintWriter writer = response.getWriter();
                    writer.write("<script>");
                    writer.write("alert('密码修改成功！');");
                    writer.write("window.location.href = 'updatePass.html'");
                    writer.write("</script>");
                    writer.flush();
                    writer.close();
                }
            }else {
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('密码错误，请重新输入！');");
                writer.write("window.location.href = 'updatePass.html'");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
