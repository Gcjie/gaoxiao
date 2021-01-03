package com.jf.servlet;

import com.jf.bean.Reward;
import com.jf.dao.RewardDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/DelRewardServlet")
public class DelRewardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String jlId = request.getParameter("jlId");
        RewardDao rewardDao = new RewardDao();

        rewardDao.delReward(jlId);
//        System.out.println(del);
        List<Reward> rewards = null;
        try {
            rewards = rewardDao.selectAllReward();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("reward", rewards);
        request.getRequestDispatcher("adm-reward.jsp").forward(request, response);
    }
}
