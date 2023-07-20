package com.user.model;

public class City {
	protected int state_id;
	protected String city;
	protected int city_id;
	
	
	public City(int state_id, String city) {
		super();
		this.state_id = state_id;
		this.city = city;
	}
	public City(int state_id, String city, int city_id) {
		super();
		this.state_id = state_id;
		this.city = city;
		this.city_id = city_id;
	}
	public int getState_id() {
		return state_id;
	}
	public void setState_id(int state_id) {
		this.state_id = state_id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	
	
	
	
}
