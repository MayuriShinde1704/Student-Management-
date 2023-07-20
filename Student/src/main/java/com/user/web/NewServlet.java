package com.user.web;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.dao.daoimpl.CityDao;
import com.user.dao.daoimpl.JDBCUserDAO;
import com.user.dao.daoimpl.MasterDao;
import com.user.dao.daoimpl.StateDao;
import com.user.dao.daoimpl.UserDAO;
import com.user.model.City;
import com.user.model.State;

import connection.ConnectionProvider;

/**
 * Servlet implementation class NewServlet
 */
//@WebServlet("/NewServlet")
public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection=null;
		try
		{
			connection=ConnectionProvider.getConnection();
			UserDAO userDao=new JDBCUserDAO(connection);
			CityDao cityDao = new MasterDao(connection);
			StateDao stateDao = new MasterDao(connection);
		    List<State> stateList= ((MasterDao) stateDao).selectState();
		    List<City> cityList= ((MasterDao) cityDao).selectCity();
			request.setAttribute("stateList", stateList);
		    request.setAttribute("cityList", cityList);
		    RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		    dispatcher.forward(request, response);
		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
