package com.newlecture.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc3")
public class Calc3 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        String value = req.getParameter("value");
        String operator = req.getParameter("operator");
        String dot = req.getParameter("dot");
        String exp = "";

        if (cookies != null) {
            for(Cookie c : cookies) {
                if(c.getName().equals("exp")) {
                    exp = c.getValue();
                    break;
                }
            }
        }

        if(operator != null && operator.equals("=")) {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("graalvm.js");
            try {
                exp = String.valueOf(engine.eval(exp));
            } catch (ScriptException e) {
                throw new RuntimeException(e);
            }
        } else if(operator != null && operator.equals("C")) {
            exp = "";
        } else {
            exp += (value == null)?"":value;
            exp += (operator == null)?"":operator;
            exp += (dot == null)?"":dot;
        }

        Cookie expCookie = new Cookie("exp", exp);
        if(operator != null && operator.equals("C")) {
            expCookie.setMaxAge(0);
        }
        resp.addCookie(expCookie);
        resp.sendRedirect("calc-page");
    }

}