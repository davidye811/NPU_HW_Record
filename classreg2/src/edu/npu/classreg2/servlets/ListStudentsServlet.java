package edu.npu.classreg2.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.npu.classreg2.services.CourseService;

@WebServlet("/liststudents.html")
public class ListStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String courseName = request.getParameter("CourseName");
		ArrayList<String> studentList = CourseService.getCourseStudents(courseName);

		out.println("<html><head><title>Student Course List</title>");
		out.println("<body><h1>List of students in " + courseName + "</h1>");

		if (studentList == null) {
			out.println("Unknown Course");
		} else if (studentList.size() == 0) {
			out.println("Currently no students are enrolled in this course");
		} else {
			out.println("<ul>");
			for (String curStudent : studentList) {
				out.println("<li>");
				out.println(curStudent);
				out.println("</li>");
			}
		}

		out.println("</ul>");
		out.println("</body></html>");
	}

}
