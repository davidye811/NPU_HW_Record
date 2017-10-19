package npuBus.servlets;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import exceptions.StudentIdnotFoundFailure;
import npuBus.domain.Student;
import npuBusService.busService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import npuBusService.busService;
@WebServlet("/servlet/register")
	public class DisplayCourseServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		@Override
		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException 
		{
			List databaseArrayList = busService.getBusList();
			request.setAttribute("databaseList", "databaseArrayList");
			String Name = request.getParameter("Name");
			String Seat = request.getParameter("Seat");
			String Description=request.getParameter("Description");
			String Carryon=request.getParameter("carryon1");
			Carryon+=" "+request.getParameter("carryon2");
		//	CourseServiceaddStudentToCourse(courseName, studentName);
//			response.sendRedirect("/admin.html");
		
//			try{
					try {
						busService.addStudentToBus(Seat, new Student(Name, Carryon, Description));
					} catch (StudentIdnotFoundFailure e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//					response.sendRedirect("/accept.jsp");
//			}catch(StudentIdnotFoundFailure e ){
//				response.sendRedirect("/reject.jsp");
//			}
					PrintWriter out = response.getWriter();
					out.println("<html>");
					out.println("<head><title>Registration Confirmation</title></head>");
					out.println("<body><h1>");
					out.println("Congratulations " + Name + "<BR></h1>");
					out.println("<h2>You are registered for " + Seat + "</h2>");
					out.println("<h2>The things that you carry" + Carryon + "</h2>");
					out.println("<h2>Your extra needs are " + Description + "</h2>");
					out.println("</body></html>");
				}
			
		}

	


