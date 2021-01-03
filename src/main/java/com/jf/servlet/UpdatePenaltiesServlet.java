package com.jf.servlet;

import com.jf.dao.PenaltiesDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/UpdatePenaltiesServlet")
public class UpdatePenaltiesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cfId = (String) request.getSession().getAttribute("SESSION_cfId");
        String cfNum = request.getParameter("cfNum");
        String cfName = request.getParameter("cfName");
        String cfUnit = request.getParameter("cfUnit");
        String cfLevel = request.getParameter("cfLevel");

        PenaltiesDao penaltiesDao = new PenaltiesDao();

        boolean pass;
        try {
            pass=penaltiesDao.updatePenalties(cfId,cfNum,cfName,cfUnit,cfLevel);
            if (pass) {
                // 添加成功就返回到页面   重定向
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('修改成功！');");
                writer.write("window.location.href = 'updatePenalties.jsp'");
                writer.write("</script>");
                writer.flush();
                writer.close();
            } else {
                // 注册失败就返回注册页面   请求转发
                RequestDispatcher dispatcher = request.getRequestDispatcher("updatePenalties.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
