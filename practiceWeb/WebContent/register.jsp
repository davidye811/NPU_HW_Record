<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="java.util.List"%>
    <%@ page import ="npuBusService.busService"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Class Registration</title>
</head>
<body> <center>
<h1>Enter Data to Register</h1>
<form name="registerForm" action="servlet/register" method="POST">
<div align="left">
Name: <input type="TEXT" name="Name"><BR>
Seat:<td>
    <select name="Seat">
        <option value="" selected>select</option>
        <%List<String> list =busService.getBusList();%>
      <%  for(int i=0;i<list.size();i++) {%>
          <%   String Field=list.get(i).toString();%>
       
        <option value="<%=Field %>"><%=Field %></option>
        <%} %>
    </select>
</td>
Description:<BR><textarea name="Description"
rows="10" cols="30"></textarea><BR>
Gender:<br>
<input name ="Gender" type="radio" name="gender" value="male" checked> Male<br>
  <input type="radio" name="gender" value="female"> Female<br>
  <input type="radio" name="gender" value="other"> Other<br>
Carry-on: <br>
 <input type="checkbox" name="carryon1" value="suitcase"> suitcase<br>
  <input type="checkbox" name="carryon2" value="pets"> pets<br>
  <input type="submit" name="Register" value="Enter">
  </div>
</form>
</body>
</html>