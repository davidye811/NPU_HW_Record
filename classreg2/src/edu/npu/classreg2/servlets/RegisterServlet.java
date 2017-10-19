package edu.npu.classreg2.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.npu.classreg2.services.CourseService;

/**
 * Servlet implementation class RegisterServlet
 */
// This servlet is called when the form is submitted from register.html
// Start with the web page:  http://localhost:8080/classreg2/register.html
@WebServlet("/servlet/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		String studentName = request.getParameter("StudentName");
		String courseName = request.getParameter("ClassName");
		CourseService.addStudentToCourse(courseName, studentName);

		out.println("<html>");
		out.println("<head><title>Registration Confirmation</title></head>");
		out.println("<body><h1>");
		out.println("Congratulations " + studentName + "<BR></h1>");
		out.println("<h2>You are registered for " + courseName + "</h2>");
		out.println("</body></html>");
	}

}
