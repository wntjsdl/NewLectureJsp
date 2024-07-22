<%--
  Created by IntelliJ IDEA.
  User: jusunkang
  Date: 2024. 7. 21.
  Time: 오후 10:53
  To change this template use File | Settings | File Templates.
--%>
<%
    int x = 3;
    int y = 4;
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>calculator</title>
    <style>
        input {
            width: 50px;
            height: 50px;
        }

        .output {
            height: 50px;
            background: #e9e9e9;
            font-size: 24px;
            font-weight: bold;
            text-align: right;
            padding: 0px 5px;
        }
    </style>
</head>
<body>
<form action="calc3" method="post">
    <table>
        <tr>
            <td class="output" colspan="4">${x+y}</td>
        </tr>
        <tr>
            <td><input type="submit" name="operator" value="CE"></td>
            <td><input type="submit" name="operator" value="C"></td>
            <td><input type="submit" name="operator" value="BS"></td>
            <td><input type="submit" name="operator" value="/"></td>
        </tr>
        <tr>
            <td><input type="submit" name="value" value="7"></td>
            <td><input type="submit" name="value" value="8"></td>
            <td><input type="submit" name="value" value="9"></td>
            <td><input type="submit" name="operator" value="*"></td>
        </tr>
        <tr>
            <td><input type="submit" name="value" value="4"></td>
            <td><input type="submit" name="value" value="5"></td>
            <td><input type="submit" name="value" value="6"></td>
            <td><input type="submit" name="operator" value="-"></td>
        </tr>
        <tr>
            <td><input type="submit" name="value" value="1"></td>
            <td><input type="submit" name="value" value="2"></td>
            <td><input type="submit" name="value" value="3"></td>
            <td><input type="submit" name="operator" value="+"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" name="value" value="0"></td>
            <td><input type="submit" name="dot" value="."></td>
            <td><input type="submit" name="operator" value="="></td>
        </tr>
    </table>
    <label>계산할 값을 입력하세요</label><br>
    <input type="text" name="v"><br>
</form>
</body>
</html>
