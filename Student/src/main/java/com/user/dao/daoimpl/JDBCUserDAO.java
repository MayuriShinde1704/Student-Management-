package com.user.dao.daoimpl;

import java.sql.Connection;
import java.time.LocalDate;  
import java.time.Period;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.user.model.User;

import constraints.DateTimeUtils;


public class JDBCUserDAO implements UserDAO{
private Connection connection;
	
	public JDBCUserDAO(Connection connection) {
		this.connection = connection;
	}

		@Override
		public void insertUser(User user) throws Exception {
			final String INSERT_USERS_SQL = "INSERT INTO users" + " (name, email,marks,cityid,stateid,birthdate,registrationdate) VALUES "
					+ " ( ?, ?, ?, ?, ?, ?, ?);";
			System.out.println(INSERT_USERS_SQL);
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
				preparedStatement.setString(1, user.getName());
				preparedStatement.setString(2, user.getEmail());
				preparedStatement.setInt(3, user.getMarks());
			    preparedStatement.setInt(4, user.getCityid());
				preparedStatement.setInt(5, user.getStateid());
				preparedStatement.setString(6,user.getBirthdate());
				preparedStatement.setString(7,DateTimeUtils.getCurrentDateTime());
				
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
				
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

		@Override
		public User selectUser(int id) throws Exception {
			User user=null ;
			final String SELECT_USER_BY_ID = "select id,name,email,marks,cityid,stateid,birthdate,registrationdate  from users where id =?";
			
			try {
					
			    PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
				preparedStatement.setInt(1, id);
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					String name = rs.getString("name");
					String email = rs.getString("email");
					int marks =rs.getInt("marks");
					int cityid=rs.getInt("cityid");
					int stateid=rs.getInt("stateid");
					String birthdate=rs.getString("birthdate");
					String registrationdate=rs.getString("registrationdate");
				
					user =new User();
					user.setName(name);
					user.setEmail(email);
					user.setMarks(marks);
					user.setCityid(cityid);
					user.setStateid(stateid);
					user.setBirthdate(birthdate);
					user.setRegistrationdate(registrationdate);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return user;
		}

		@Override
		public List<User> selectAllUsers() throws Exception {
			final String SELECT_ALL_USERS = "SQLQuery";
			
			StringBuffer SQLQuery=new StringBuffer();
 
			
	SQLQuery.append("SELECT users.id, users.name, users.email, ");
	SQLQuery.append("users.marks,users.registrationdate, birthdate,");
	SQLQuery.append("state.state,city.city  ");
	SQLQuery.append("FROM users INNER JOIN state ON state.state_id=users.stateid ");
	SQLQuery.append(" INNER JOIN city on city.city_id=users.cityid; ");
			
		
			List<User> users = new ArrayList<>();
			
			try {

				PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery.toString());
				System.out.println(preparedStatement);
			   
				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					
					User student = new User();
					student.setId(rs.getInt("id"));
					student.setName(rs.getString("name"));
					student.setEmail(rs.getString("email"));
					student.setMarks(rs.getInt("marks"));
					student.setCity(rs.getString("city"));
					student.setState(rs.getString("state"));
					student.setBirthdate(DateTimeUtils.parseDateToDDMMYYYY(rs.getDate("birthdate")));
					student.setRegistrationdate(DateTimeUtils.parseDateToDDMMYYYY(rs.getDate("registrationdate")));
					
					student.setAge(DateTimeUtils.calculateAge(rs.getString("birthdate")));
					users.add(student);
				}
			} catch (SQLException e) {
			e.printStackTrace();
			}
			return users;
		}

		@Override
		public boolean deleteUser(int id) throws Exception {
			final String DELETE_USERS_SQL = "delete from users where id = ?;";
			boolean rowDeleted = false;
			try 
			{
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);
				statement.setInt(1, id);
				rowDeleted = statement.executeUpdate() > 0;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return rowDeleted;
			
		}

		@Override
		public boolean updateUser(User user) throws Exception {
			boolean rowUpdated = false;
			final String UPDATE_USERS_SQL = "update users set name = ?,email= ?,marks =?,cityid=?,stateid=?,birthdate=?,registrationdate=? where id = ?;";

			try 
			{
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);
				 statement.setString(1, user.getName());
				 statement.setString(2, user.getEmail());
				 statement.setInt(3, user.getMarks());
			     statement.setInt(4, user.getCityid());
			     statement.setInt(5, user.getStateid());
			     statement.setString(6, user.getBirthdate());
			     statement.setString(7,DateTimeUtils.getCurrentDateTime());
			     statement.setInt(8, user.getId());
			    
			     rowUpdated = statement.executeUpdate() > 0;
			     
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return rowUpdated;
			
		}



}
