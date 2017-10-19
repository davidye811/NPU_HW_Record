package edu.npu.classreg2.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.npu.classreg2.domain.Course;
import edu.npu.classreg2.services.CourseService;

// To run this servlet, point your browser to:  http://localhost:8080/classreg2/listcourses.html
@WebServlet("/listcourses.html")
public class ListCoursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String courseName;
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		ArrayList<Course> courseList = CourseService.getCourseList();

		out.println("<html><head><title>List of Courses</title>");
		out.println("<body><h1>List of courses:</h1>");

		if (courseList == null || courseList.size() == 0) {
			out.println("No courses available at this time");
		} else {
			out.println("<ul>");
			for (Course curCourse : courseList) {
				courseName = curCourse.getName();
				out.println("<li>");
				//out.println(courseName);
				/* OR, use a hyperlink as shown below -- uncomment */
				 out.println("<a href=/classreg2/liststudents.html?CourseName="
				 + courseName + ">" + courseName + "</a>");
				out.println("</li>");
			}
		}

		out.println("</ul>");
		out.println("</body></html>");
	}
}
