<%@ page import="wc.service.CarService" %>
<%@ page import="java.util.List" %>
<%@ page import="wc.entity.Car" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <table>
    <tr>
      <td>car name</td>
      <td>company</td>
    </tr>
    <%
      List<Car> carList = CarService.getCarService().findAll();
      for (Car dbcar : carList) {
    %>
    <tr>
      <td><%=dbcar.getName()%></td>
      <td><%=dbcar.getCompany()%></td>
    </tr>
    <%
      }
    %>
  </table>
</body>
</html>
