package com.concentration.J2EE;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhaoxu
 * @className MyHttpServlet
 * @projectName JavaConcentration

 * @date 2/28/2020 11:25 PM
 */


@WebServlet(name ="myhttpservlet",urlPatterns = "/myhttpservleturl")
public class MyHttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("call do get");

        Cookie[] cookies =  req.getCookies();
        for (Cookie cookie:cookies) {
            System.out.println(cookie.toString());
        }

        resp.getWriter().write(cookies.toString());





    }
}
