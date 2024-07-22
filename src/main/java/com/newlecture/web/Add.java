package com.newlecture.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add")
public class Add extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();

        String x = req.getParameter("x");
        String y = req.getParameter("y");
        int intX = 0, intY = 0;

        try {
            intX = Integer.parseInt(x);
            intY = Integer.parseInt(y);
            out.println("<h1>" + x + " + " + y + " = " + (intX + intY) + "</h1>");
        } catch (NumberFormatException ex) {
            out.println("<h1>숫자를 제대로 입력하세요!</h1>");
            ex.printStackTrace();
        }
    }
}
