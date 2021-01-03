package com.jf.servlet;

import com.jf.bean.Penalties;
import com.jf.dao.PenaltiesDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/AddPenaltiesServlet")
public class AddPenaltiesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String cfId = request.getParameter("cfId");
        String cfNum = request.getParameter("cfNum");
        String cfName = request.getParameter("cfName");
        String cfUnit = request.getParameter("cfUnit");
        String cfLevel = request.getParameter("cfLevel");

        Penalties penalties = new Penalties(cfId,cfNum,cfName,cfUnit,cfLevel);

        PenaltiesDao penaltiesDao = new PenaltiesDao();

        // flag是否添加成功
        boolean flag = penaltiesDao.savePenalties(penalties);

        if (flag) {
            // 添加成功就返回到页面   重定向
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('添加成功！');");
            writer.write("window.location.href = 'addPenalties.html'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        } else {
            // 注册失败就返回注册页面   请求转发
            RequestDispatcher dispatcher = request.getRequestDispatcher("addPenalties.html");
            dispatcher.forward(request, response);
        }
    }
}
