package nvz.servlets;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import nvz.data.Course;
import nvz.services.CourseService;

public class RegForCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,  HttpServletResponse response) 
    throws ServletException, IOException   
{
		String courseName;
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		ArrayList<Course> courseList = CourseService.getCourseList();

		out.println("<html><head><title>Course Registration</title>");
		out.println("<body><h1>Current Course Offerings:</h1>");
		
		if (courseList == null || courseList.size()== 0) {
			out.println("No courses available at this time"); 
		} else {
			out.println("<ul>");
			for (Course curCourse : courseList) {
				courseName = curCourse.getName();
				out.println("<li>");
				out.println(" <form method='post' action='addCourseToCart.html'>");
				out.println("<b>" + courseName + "</b>" + "&nbsp;&nbsp;");
				out.println("<input type='hidden' name='courseId' value='" + courseName + "'/>");
				out.println("<input type='submit' value='Add To Cart'/>");
				out.println("</form>");
				out.println("</li>");
			}
			out.println("</ul>");
		}
		
		out.println("</body></html>");
	}
}

