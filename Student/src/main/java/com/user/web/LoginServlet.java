package com.user.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        
        if (email != null && email.equalsIgnoreCase("mayuri@gmail.com") && password != null && password.equalsIgnoreCase("1234")) {
           
        	HttpSession httpSession = request.getSession();
        	httpSession.setAttribute("email", email);
            request.getRequestDispatcher("list").forward(request, response);
        }
        else {
        	
        	response.sendRedirect("Error.jsp");

        }
        
        
	}
}
