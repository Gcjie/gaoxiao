package com.jf.servlet;

import com.jf.bean.Penalties;
import com.jf.dao.PenaltiesDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/LookPenaltiesServlet")
public class LookPenaltiesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String num= (String)request.getSession().getAttribute("SESSION_num");
        PenaltiesDao penaltiesDao = new PenaltiesDao();
        try {
            List<Penalties> penalties = penaltiesDao.selectNum(num);
            if (penalties.size()!=0){
                request.setAttribute("penalties",penalties);
                request.getRequestDispatcher("lookPenalties.jsp").forward(request,response);
            }
            else{
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('没受过处罚！');");
                writer.write("window.location.href = 'lookPenalties.jsp'");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
