package com.newlecture.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/calc-page")
public class CalcPage extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        String exp = "0";

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("exp")) {
                    exp = c.getValue();
                    break;
                }
            }
        }

        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>calc</title>");
        out.println("<style>");
        out.println("input {");
        out.println("width: 50px;");
        out.println("height: 50px;");
        out.println("}");
        out.println(".output {");
        out.println("height: 50px;");
        out.println("background: #e9e9e9;");
        out.println("font-size: 24px;");
        out.println("font-weight: bold;");
        out.println("text-align: right;");
        out.println("padding: 0px 5px;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action=\"calc3\" method=\"post\">");
        out.println("<table>");
        out.println("<tr>");
        out.printf("<td class=\"output\" colspan=\"4\">%s</td>", exp);
        out.println("</tr>");
        out.println("<tr>");
        out.println("<tr>");
        out.println("<td><input type=\"submit\" name=\"operator\" value=\"CE\"></td>");
        out.println("<td><input type=\"submit\" name=\"operator\" value=\"C\"></td>");
        out.println("<td><input type=\"submit\" name=\"operator\" value=\"BS\"></td>");
        out.println("<td><input type=\"submit\" name=\"operator\" value=\"/\"></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<tr>");
        out.println("<td><input type=\"submit\" name=\"value\" value=\"7\"></td>");
        out.println("<td><input type=\"submit\" name=\"value\" value=\"8\"></td>");
        out.println("<td><input type=\"submit\" name=\"value\" value=\"9\"></td>");
        out.println("<td><input type=\"submit\" name=\"operator\" value=\"*\"></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td><input type=\"submit\" name=\"value\" value=\"4\"></td>");
        out.println("<td><input type=\"submit\" name=\"value\" value=\"5\"></td>");
        out.println("<td><input type=\"submit\" name=\"value\" value=\"6\"></td>");
        out.println("<td><input type=\"submit\" name=\"operator\" value=\"-\"></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td><input type=\"submit\" name=\"value\" value=\"1\"></td>");
        out.println("<td><input type=\"submit\" name=\"value\" value=\"2\"></td>");
        out.println("<td><input type=\"submit\" name=\"value\" value=\"3\"></td>");
        out.println("<td><input type=\"submit\" name=\"operator\" value=\"+\"></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td></td>");
        out.println("<td><input type=\"submit\" name=\"value\" value=\"0\"></td>");
        out.println("<td><input type=\"submit\" name=\"dot\" value=\".\"></td>");
        out.println("<td><input type=\"submit\" name=\"operator\" value=\"=\"></td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("<label>계산할 값을 입력하세요</label><br>");
        out.println("<input type=\"text\" name=\"v\"><br>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}