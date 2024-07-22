package com.newlecture.web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc")
public class Calc extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();

        String x = req.getParameter("x");
        String y = req.getParameter("y");
        String operator = req.getParameter("operator");
        int intX = 0, intY = 0, result = 0;

        try {
            intX = Integer.parseInt(x);
            intY = Integer.parseInt(y);
            if (operator.equals("더하기")) {
                result = intX + intY;
                out.println("<h1>" + x + " + " + y + " = " + result + "</h1>");
            } else if (operator.equals("빼기")) {
                result = intX - intY;
                out.println("<h1>" + x + " - " + y + " = " + result + "</h1>");
            }
        } catch (NumberFormatException ex) {
            out.println("<h1>숫자를 제대로 입력하세요!</h1>");
            ex.printStackTrace();
        }
    }
}