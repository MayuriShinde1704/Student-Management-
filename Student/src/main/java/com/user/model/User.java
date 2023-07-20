package com.user.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;

import constraints.DateTimeUtils;

public class User  implements Comparator<User>{
	
	private String registrationdate;
	private int id;
	private String name;
	private String email;
	private int marks;
	private String city;
	private String state;
	private int  cityid;
	private int stateid;
	private String birthdate;
	private int age;
	


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age=age;
	}


	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}


	public String getRegistrationdate() {
		
		return registrationdate;
	}

	public void setRegistrationdate(String registrationdate) {
		this.registrationdate =registrationdate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getCityid() {
	return cityid;
}

public void setCityid(int cityid) {
	this.cityid = cityid;
}

public int getStateid() {
	return stateid;
}

public void setStateid(int stateid) {
	this.stateid = stateid;
}


@Override
public int compare(User o1, User o2) {
	
	return o1.state.compareTo(o2.state);
}
	
	
}
