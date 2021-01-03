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

@WebServlet(urlPatterns = "/SelectPenaltiesServlet")
public class SelectPenaltiesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String num = request.getParameter("stuNum");
        PenaltiesDao penaltiesDao = new PenaltiesDao();
        try {
            List<Penalties> penalties = penaltiesDao.selectNum(num);
//            System.out.println(students);
            if(penalties.size()!=0)
            {
                request.setAttribute("penalties",penalties);
                request.getRequestDispatcher("adm-penalties.jsp").forward(request,response);
            }
            else if(num.equals("")){
                List<Penalties> pen = null;
                pen=penaltiesDao.selectAllPenalties();
//                System.out.println(rew);
                request.setAttribute("penalties",pen);
                request.getRequestDispatcher("adm-penalties.jsp").forward(request, response);
            }
            else {
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('学号不存在！');");
                writer.write("window.location.href = 'adm-penalties.jsp'");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
