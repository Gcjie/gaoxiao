package com.jf.servlet;

import com.jf.bean.Penalties;
import com.jf.dao.PenaltiesDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/DelPenaltiesServlet")
public class DelPenaltiesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String cfId = request.getParameter("cfId");
        PenaltiesDao penaltiesDao = new PenaltiesDao();

        penaltiesDao.delPenalties(cfId);
//        System.out.println(del);
        List<Penalties> penalties = null;
        try {
            penalties = penaltiesDao.selectAllPenalties();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("penalties", penalties);
        request.getRequestDispatcher("adm-penalties.jsp").forward(request, response);
    }
}
