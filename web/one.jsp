<%@ page import="wc.entity.Car" %>
<%@ page import="wc.service.CarService" %><%--
  Created by IntelliJ IDEA.
  User: saeid
  Date: 1/3/2023
  Time: 5:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%
    String name = request.getParameter("name");
    String company = request.getParameter("company");
    Car car = new Car(name, company);
    CarService.getCarService().save(car);
    response.sendRedirect("/two.jsp");
  %>
</body>
</html>
