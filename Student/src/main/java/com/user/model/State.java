package com.user.model;

public class State {
	protected int state_id;
	protected String state;
	
	
	public State(int state_id, String state) {
		super();
		this.state_id = state_id;
		this.state = state;
	}
	
	
	public State(String state) {
		super();
		this.state = state;
	}



	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getState_id() {
		return state_id;
	}
	public void setState_id(int state_id) {
		this.state_id = state_id;
	}
	
	
}
