package com.jf.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = {
        "/AdminRegisterServlet", "/AdminLoginServlet","/AddStudentServlet","/StudentLoginServlet", "/DelStudentServlet",
        "/SelectRewardServlet", "/SelectStudentServlet", "/UpdatePassServlet", "/UpdateStudentServlet", "/UpdateServlet",
        "/AddRewardServlet", "/UpdateRewServlet", "/UpdateRewardServlet", "/DelRewardServlet", "/SelectPenaltiesServlet",
        "/AddPenaltiesServlet", "/DelPenaltiesServlet", "/UpdatePenServlet", "/UpdatePenaltiesServlet"
})
public class FormatFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
