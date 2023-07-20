package com.user.web;

import java.io.IOException;
import java.sql.Connection;
import java.util.*;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.dao.daoimpl.JDBCUserDAO;
import com.user.dao.daoimpl.UserDAO;
import com.user.model.User;

import connection.ConnectionProvider;

/**
 * Servlet implementation class ListController
 */
//@WebServlet("/ListController")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection=null;
		try
		{
			connection=ConnectionProvider.getConnection();
			UserDAO userDao=new JDBCUserDAO(connection);
			List<User> listUser = userDao.selectAllUsers();
			//Collections.sort(listUser);
			Collections.sort(listUser,new User());
			request.setAttribute("listUser", listUser);
			RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
			dispatcher.forward(request, response);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
