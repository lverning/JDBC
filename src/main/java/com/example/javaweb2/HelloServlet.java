package com.example.javaweb2;

import com.example.javaweb2.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//添加注解
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        UserDao dao = new UserDao();
        User user = null;
        int result = 0;
        PrintWriter out = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        user = new User(username, password);
        result = dao.add(user);
        out = response.getWriter();
        if (result !=0){
            out.print("<font style='color:red;font-size:40'>注册成功</font>");
        }else {
            out.print("<font style='color:red;font-size:40'>注册失败</font>");
        }
    }
}