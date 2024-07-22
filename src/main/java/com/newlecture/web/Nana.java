package com.newlecture.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

 @WebServlet("/hi")
public class Nana extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();

        String temp = req.getParameter("cnt");

        int cnt = 100;
        if(temp != null && !temp.isEmpty()) {
            cnt = Integer.parseInt(temp);
        }

        for (int i = 0; i < cnt; i++) {
            out.println((i+1)+": 안녕 Hello Servlet!!<br>");
        }
    }
}
