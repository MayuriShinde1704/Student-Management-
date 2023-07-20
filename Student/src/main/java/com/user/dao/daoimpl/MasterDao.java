package com.user.dao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.user.model.City;
import com.user.model.State;
import com.user.model.User;

public class MasterDao implements StateDao,CityDao{
	private Connection connection;
	
	public MasterDao(Connection connection) {
		this.connection = connection;
	}
	@Override
	public List<State> selectState() throws Exception {
		 final String SELECT = "select * from state;";
		 
		List<State> st= new ArrayList<>();
		try{
	
			PreparedStatement pstmt = connection.prepareStatement(SELECT);
			System.out.println(pstmt);
			
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				int state_id=rs.getInt("state_id");
				String state=rs.getString("state");
				st.add(new State(state_id,state));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return st;
	}

	@Override
	public List<City> selectCity() throws Exception {
		 final String SELECT = "select * from city;";
		 
		List<City> ct= new ArrayList<>();
		try{
	
			PreparedStatement pstmt = connection.prepareStatement(SELECT);
			System.out.println(pstmt);
			
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				int state_id=rs.getInt("state_id");
				int city_id=rs.getInt("city_id");
				String city=rs.getString("city");
				ct.add(new City(state_id,city,city_id));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ct;
	}

}

	
