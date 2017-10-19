//package npuBus.servlets;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import exceptions.StudentIdnotFoundFailure;
//import npuBus.domain.Bus;
//import npuBusService.busService;
//
//@WebServlet("/servlet/reject")
//	public class DisplayBusServlet extends HttpServlet {
//		private static final long serialVersionUID = 1L;
//
//		@Override
//		public void doPost(HttpServletRequest request, HttpServletResponse response)
//				throws ServletException, IOException{
//			PrintWriter out = response.getWriter();
//			String busid = request.getParameter("Busid");
//			String drivername = request.getParameter("drivername");
//			String phone=request.getParameter("phone");
//			int capability=Integer.valueOf(request.getParameter("capability"));
//		//	CourseServiceaddStudentToCourse(courseName, studentName);
//			
//				busService.insertOrUpadateBus(new Bus( busid,  capability,  drivername,  phone));
//			
//			out.println("<html>");
//			out.println("<head><title>Add Confirmation</title></head>");
//			out.println("<body><h1>");
//			out.println("Congratulations Administration"  + "<BR></h1>");
//			out.println("<h2>You are registered for " + busid + "</h2>");
//			out.println("<h2>driver name: " + drivername + "</h2>");
//			out.println("<h2>phone" + phone + "</h2>");
//			out.println("<h2>capability " + capability + "</h2>");
//			
//			out.println("</body></html>");
//		}
//
//	}
