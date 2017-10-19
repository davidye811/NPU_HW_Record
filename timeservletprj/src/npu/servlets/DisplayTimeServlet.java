package npu.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class DisplayTimeServlet extends HttpServlet {
	public void service(HttpServletRequest request, 
	                                HttpServletResponse response) 
	           throws ServletException, IOException   
	{
	     PrintWriter out = response.getWriter();
	     GregorianCalendar currentDate = new GregorianCalendar();

	     out.println("<h1>Time Now: " +    
                               currentDate.get(Calendar.HOUR_OF_DAY) + ":" + 
                               currentDate.get(Calendar.MINUTE) + "</h1>");
	}
}

