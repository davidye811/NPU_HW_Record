package nvz.servlets;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import nvz.data.Course;
import nvz.services.CourseService;

// Use URL:   	
// See web.xml file for servlet mappings

/* Note: The following would be great improvements to this servlet:
 *     1.   There should be a ShoppingCart class instead of ArrayList<Course>
 *     2.   We should verify that the course id is valid and give proper error if not
 *     3.   We should make sure the user is not already registered for the course (prevent double registration)
 */
public class AddCourseToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,  HttpServletResponse response) 
    throws ServletException, IOException   
{
		String courseName;
		ArrayList<Course> cart;  // really should have a ShoppingCart class
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		courseName = request.getParameter("courseId");
		Course course = CourseService.getCourse(courseName);
		cart = (ArrayList<Course>) session.getAttribute("cart");

		if (cart == null) {
			// First course being added by the user
			cart = new ArrayList<Course>();
			session.setAttribute("cart", cart);
		}
		
		cart.add(course);
		out.println("<html><head><title>List of Courses</title>");
		out.println("<body><h1>You are now registered for: " + courseName + "</h1>");
		
		out.println("<br><a href=/registration/register.html>Register For More Courses</a>");
		out.println("&nbsp;&nbsp;&nbsp;");  // Add some blank spaces
		out.println("<a href=/registration/showCart.html>Shopping Cart</a>");
		out.println("</body></html>");
	}
}

