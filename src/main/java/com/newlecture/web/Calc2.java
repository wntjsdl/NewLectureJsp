package com.newlecture.web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ServletContext application = req.getServletContext();
//        HttpSession session = req.getSession();
        Cookie[] cookies = req.getCookies();

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();

        String v_ = req.getParameter("v");
        String op = req.getParameter("op");

        int v = 0;

        if(!v_.equals("")) {
            v = Integer.parseInt(v_);
        }

        if(op.equals("=")) { // 계산
//            int x = (Integer)application.getAttribute("value");
//            int x = (Integer)session.getAttribute( "value");
            int x = 0;
            for(Cookie c : cookies) {
                if(c.getName().equals("value")) {
                    x = Integer.parseInt(c.getValue());
                    break;
                }
            }
            int y = v;
//            String operator = (String)application.getAttribute("op");
//            String operator = (String)session.getAttribute("op");
            String operator = "";
            for(Cookie c : cookies) {
                if(c.getName().equals("op")) {
                    operator = c.getValue();
                    break;
                }
            }
            int result = 0;

            if(operator.equals("+")) {
                result = x+y;
            } else {
                result = x-y;
            }

            resp.getWriter().printf("result is %d\n", result);
        } else { // 값 저장
//            application.setAttribute("value", v);
//            application.setAttribute("op", op);
//            session.setAttribute("value", v);
//            session.setAttribute("op", op);
            Cookie valueCookie = new Cookie("value", String.valueOf(v));
            Cookie opCookie = new Cookie("op", op);
            valueCookie.setPath("/calc2");
            valueCookie.setMaxAge(24*60*60);
            opCookie.setPath("/calc2");
            resp.addCookie(valueCookie);
            resp.addCookie(opCookie);

            resp.sendRedirect("calc2.html");
        }

    }
}