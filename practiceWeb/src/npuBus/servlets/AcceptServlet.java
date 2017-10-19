package npuBus.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exceptions.StudentIdnotFoundFailure;
import npuBus.domain.Bus;
import npuBusService.busService;

@WebServlet("/servlet/admin")
	public class AcceptServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		@Override
		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException 
		{
			PrintWriter out = response.getWriter();
			String busid = request.getParameter("Busid");
			String drivername = request.getParameter("drivername");
			String phone=request.getParameter("phone");
			int capability=Integer.valueOf(request.getParameter("capability"));
		//	CourseServiceaddStudentToCourse(courseName, studentName);
			Bus bus=new Bus( busid,  capability,  drivername,  phone);
				busService.insertOrUpadateBus(bus);
			HttpSession session = request.getSession();
			
			request.setAttribute("businfo", bus);
			ServletContext context =getServletContext();
			RequestDispatcher dispatch =context.getRequestDispatcher("/Accept.jsp");
			dispatch.forward(request, response);
		}

	}