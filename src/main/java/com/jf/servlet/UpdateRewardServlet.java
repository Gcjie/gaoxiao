package com.jf.servlet;

import com.jf.dao.RewardDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/UpdateRewardServlet")
public class UpdateRewardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jlId = (String) request.getSession().getAttribute("SESSION_jlId");
        String jlNum = request.getParameter("jlNum");
        String jlName = request.getParameter("jlName");
        String jlUnit = request.getParameter("jlUnit");
        String jlLevel = request.getParameter("jlLevel");

        RewardDao rewardDao = new RewardDao();

        boolean pass;
        try {
            pass=rewardDao.updateReward(jlId,jlNum,jlName,jlUnit,jlLevel);
            if (pass) {
                // 添加成功就返回到页面   重定向
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('修改成功！');");
                writer.write("window.location.href = 'updateReward.jsp'");
                writer.write("</script>");
                writer.flush();
                writer.close();
            } else {
                // 注册失败就返回注册页面   请求转发
                RequestDispatcher dispatcher = request.getRequestDispatcher("updateReward.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
