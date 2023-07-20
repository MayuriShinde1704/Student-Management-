package com.user.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.dao.daoimpl.JDBCUserDAO;
import com.user.dao.daoimpl.UserDAO;

import connection.ConnectionProvider;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection=null;
		try
		{
			connection=ConnectionProvider.getConnection();
			UserDAO userDao=new JDBCUserDAO(connection);
		int id = Integer.parseInt(request.getParameter("id"));
		userDao.deleteUser(id);
		response.sendRedirect("list");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
