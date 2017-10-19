<!-- Use URL:  http://localhost:8080/jspgreeting/greeting.jsp  -->
<html>
<head><title>Daily Greeting</title></head>
<body>
<center>
<%@ page import="java.util.*" %>
Good

<%
        GregorianCalendar currentDate = new GregorianCalendar();

        if (currentDate.get(Calendar.HOUR_OF_DAY) < 12) {
%>
Morning!
<%      } else {   %>
Afternoon!
<%      }          %>
<%=
currentDate.get(Calendar.HOUR_OF_DAY)
%>
</center>
</body>
</html> 
