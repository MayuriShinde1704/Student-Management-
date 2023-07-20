package com.user.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.dao.daoimpl.JDBCUserDAO;
import com.user.dao.daoimpl.UserDAO;
import com.user.model.User;

import connection.ConnectionProvider;
import constraints.DateTimeUtils;


//@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private  static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	 {
		Connection connection=null;
		try
		{
			connection=ConnectionProvider.getConnection();
			UserDAO userDao=new JDBCUserDAO(connection);
			 
			User newUser=new User();
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			int marks = Integer.parseInt(request.getParameter("marks"));
			int cityid = Integer.parseInt(request.getParameter("city"));
			int stateid = Integer.parseInt(request.getParameter("state"));
			String birthdate=request.getParameter("birthdate");
			String registrationdate=request.getParameter(DateTimeUtils.getCurrentDateTime());
			
			
			newUser.setName(name);
			newUser.setEmail(email);
			newUser.setMarks(marks);
			newUser.setCityid(cityid);
			newUser.setStateid(stateid);
			newUser.setBirthdate(birthdate);
			newUser.setRegistrationdate(registrationdate);
			userDao.insertUser(newUser);
			response.sendRedirect("list");
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		}

	private Date Date(String parameter) {
		// TODO Auto-generated method stub
		return null;
	}
	 }

	


