package com.yancheng.week4.demo;



import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        urlPatterns={"/config"},
        initParams={
                @WebInitParam(name="name",value="YanCheng"),
                @WebInitParam(name="studentID",value = "2019211001001206"),
        },loadOnStartup = 1
)

public class configdemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer=response.getWriter();
        writer.println("name:"+getServletConfig().getInitParameter("name"));
        writer.println("studentID:"+getServletConfig().getInitParameter("studentID"));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}