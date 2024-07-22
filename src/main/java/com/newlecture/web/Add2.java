package com.newlecture.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add2")
public class Add2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();

        String[] num = req.getParameterValues("num");

        int result = 0;


        try {
            String s = "<h1>" + num[0];
            for (int i = 0; i < num.length; i++) {
                int intNum = Integer.parseInt(num[i]);
                if (i != 0) {
                    s += " + " + intNum;
                }
                result += intNum;
            }
            s += " = " + result + "</h1>";
            out.println(s);
        } catch (NumberFormatException ex) {
            out.println("<h1>숫자를 제대로 입력하세요!</h1>");
            ex.printStackTrace();
        }
    }
}
