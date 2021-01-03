package com.jf.servlet;

import com.jf.bean.Reward;
import com.jf.dao.RewardDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/LookRewardServlet")
public class LookRewardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String num= (String)request.getSession().getAttribute("SESSION_num");
        RewardDao rewardDao = new RewardDao();
        try {
            List<Reward> rewards = rewardDao.selectNum(num);
            if (rewards.size()!=0){
                request.setAttribute("reward",rewards);
                request.getRequestDispatcher("lookReward.jsp").forward(request,response);
            }
            else{
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('没获得过奖项！');");
                writer.write("window.location.href = 'lookReward.jsp'");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
