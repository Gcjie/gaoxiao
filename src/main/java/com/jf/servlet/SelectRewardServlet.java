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

@WebServlet(urlPatterns = "/SelectRewardServlet")
public class SelectRewardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String num = request.getParameter("stuNum");
        RewardDao rewardDao = new RewardDao();
        try {
            List<Reward> rewards = rewardDao.selectNum(num);
//            System.out.println(students);
            if(rewards.size()!=0)
            {
                request.setAttribute("reward",rewards);
                request.getRequestDispatcher("adm-reward.jsp").forward(request,response);
            }
            else if(num.equals("")){
                List<Reward> rew = null;
                rew=rewardDao.selectAllReward();
//                System.out.println(rew);
                request.setAttribute("reward", rew);
                request.getRequestDispatcher("adm-reward.jsp").forward(request, response);
            }
            else {
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('学号不存在！');");
                writer.write("window.location.href = 'adm-reward.jsp'");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
