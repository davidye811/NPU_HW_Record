package edu.npu.courseapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*  NOTE, Use this URL:  http://localhost:8080/classreg1/register.html  */

@WebServlet("/servlet/register")
public class RegisterServlet extends HttpServlet {

    public void service(HttpServletRequest request,  HttpServletResponse response) 
           throws ServletException, IOException   
    {
       PrintWriter out = response.getWriter();
       String studentName = request.getParameter("StudentName");
       String courseName = request.getParameter("ClassName");

       out.println("<html>");
            out.println("<head><title>Registration Confirmation</title></head>");
            out.println("<body><h1>");
            out.println("Congratulations " + studentName + "<BR></h1>");
            out.println("<h2>You are registered for " + courseName + "</h2>");   
            out.println("</body></html>");
    }

}
