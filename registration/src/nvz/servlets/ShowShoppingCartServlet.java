package nvz.servlets;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import nvz.data.Course;

/* Note: The following would be great improvements to this servlet:
 *     1.   Add a "Remove from Cart" button or hyperlink next to each course
 *     2.   Add a link to a checkout servlet
 *     3.   We should have a ShoppingCart class instead of ArrayList<Course>
 *     4.   We could compute and display the cost of all the courses in the shopping cart
 */ 
public class ShowShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,  HttpServletResponse response) 
    throws ServletException, IOException   
    {
		ArrayList<Course> cart;  // really should have a ShoppingCart class
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		HttpSession session = request.getSession();
		cart = (ArrayList<Course>) session.getAttribute("cart");
		out.println("<html><body>");
		
		if (cart == null) {
			out.println("<h1>Your shopping cart is empty</h1>");
		} else {
			out.println("<h1>Your Shopping Cart</h1><ul>");
			for (Course course : cart) {
				out.println("<li>" + course.getName() + "</li>");
			}
			out.println("</h1></ul>");
		}
		
		out.println("<br><a href=/registration/register.html>Register For More Courses</a>");
		out.println("</body></html>");
		out.close();

    }
}
