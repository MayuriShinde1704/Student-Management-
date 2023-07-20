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
import com.user.model.User;

import connection.ConnectionProvider;

//@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	 {
		Connection connection=null;
		try
		{
		    connection=ConnectionProvider.getConnection();
		    UserDAO userDao=new JDBCUserDAO(connection);
		    int id = Integer.parseInt(request.getParameter("id"));
		    User existingUser = userDao.selectUser(id);
		    existingUser.setId(id);
		    CityDao cityDao = new MasterDao(connection);
			StateDao stateDao = new MasterDao(connection);
		    List<City> cityList= ((MasterDao) cityDao).selectCity();
		     List<State> stateList= ((MasterDao) stateDao).selectState();
		     request.setAttribute("cityList", cityList);
			 request.setAttribute("stateList", stateList);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
			request.setAttribute("user", existingUser);
			
			dispatcher.forward(request, response);
			}catch(Exception e)
			{
				e.printStackTrace();
			}

		}
		}
 
