package com.concentration.J2EE;

import org.springframework.boot.web.servlet.server.Session;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import java.io.IOException;

/**
 * @author zhaoxu
 * @className MyServlet
 * @projectName JavaConcentration

 * @date 2/28/2020 6:58 PM
 */
@WebServlet(name = "myservlet",urlPatterns = "/myservleturl")
public class MyServlet implements Servlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("call method init()!");

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
//Servlet带给我们最大的作用就是能够处理浏览器带来HTTP请求，并返回一个响应给浏览器，从而实现浏览器和服务器的交互。

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("call method service()!");
        res.getWriter().write("hello servlet!");


    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("call method destroy()!");
    }
}
