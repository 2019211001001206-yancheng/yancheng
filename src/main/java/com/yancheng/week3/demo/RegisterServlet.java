package com.yancheng.week3.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//automatic-new--> servlet
@WebServlet(name = "RegisterServlet",value = "/register")
public class RegisterServlet extends HttpServlet {
    public Connection dbConn;
    public void init(){
        try{
            Class.forName(getServletConfig().getServletContext().getInitParameter("driver"));
            dbConn= DriverManager.getConnection(getServletConfig().getServletContext().getInitParameter("url"),getServletConfig().getServletContext().getInitParameter("username"),getServletConfig().getServletContext().getInitParameter("password"));
            System.out.println(dbConn);
        }catch (Exception e){System.out.println(e);}
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// request  come here -<from method=post>
        //get parameter from request
        String username =request.getParameter( "username");//name of input type -<input type="text" name="username"/></br>
        String password =request.getParameter( "password");//<input type="password" name="password"/>
        String email =request.getParameter( "email");//<input type="text" name="email"/>
        String gender =request.getParameter( "gender");//<input type="text" name="gender"/>
        String birthDate =request.getParameter( "birthDate");//<input type="text" name="birthDate"/>



        //print - write into response
        PrintWriter writer = response.getWriter();
        //writer.println( "<br>name :"+username);
        //writer.println( "<br>id :"+password);
        //writer.println( "<br>email :"+email);
        //writer.println( "<br>gender :"+gender);
        //writer.println( "<br>birth Date :"+birthDate);
       //writer.close();
        String[][] ret = new String[100][5];
        int cat = 0;
        try {
            Statement createDbStatement = dbConn.createStatement();
            String ADDdbRequire = "insert into usertable values('','" + username + "','" + password + "','" + email + "','" + gender + "','" + birthDate + "')";
            createDbStatement.executeUpdate(ADDdbRequire);
            String dbRequire = "select * from usertable";
            ResultSet resultDb = createDbStatement.executeQuery(dbRequire);
            while (resultDb.next()) {
                ret[cat][0] = resultDb.getObject(1).toString().trim();
                ret[cat][1] = resultDb.getObject(2).toString().trim();
                ret[cat][2] = resultDb.getObject(3).toString().trim();
                ret[cat][3] = resultDb.getObject(4).toString().trim();
                ret[cat++][4] = resultDb.getObject(5).toString().trim();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        writer.println("<table border=\"1\">");
        writer.println("<tr<td>id</td><td>username</td><td>Password</td><td>Email</td><td>Birthdate</td><td>sex</td></tr>");
        for (int i = 0; i < cat; i++) {
            for (int j = 0; j < 5; j++) {
                writer.println("<td>" + ret[i][j] + "</td>");
            }
            writer.println("</tr>");
        }
        writer.println("</table>");
    }
}
