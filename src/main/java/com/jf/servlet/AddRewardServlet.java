package com.jf.servlet;

import com.jf.bean.Reward;
import com.jf.dao.RewardDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/AddRewardServlet")
public class AddRewardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String jlId = request.getParameter("jlId");
        String jlNum = request.getParameter("jlNum");
        String jlName = request.getParameter("jlName");
        String jlUnit = request.getParameter("jlUnit");
        String jlLevel = request.getParameter("jlLevel");

//        System.out.println(jlId+jlNum+jlName+jlUnit+jlLevel);
        Reward reward = new Reward(jlId,jlNum,jlName,jlUnit,jlLevel);

        RewardDao rewardDao = new RewardDao();

        // flag是否添加成功
        boolean flag = rewardDao.saveReward(reward);

        if (flag) {
            // 添加成功就返回到页面   重定向
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('添加成功！');");
            writer.write("window.location.href = 'addReward.html'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        } else {
            // 注册失败就返回注册页面   请求转发
            RequestDispatcher dispatcher = request.getRequestDispatcher("addReward.html");
            dispatcher.forward(request, response);
        }
    }
}
