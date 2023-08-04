package com.caresoft.clinicapp;

public class User {
	 private  Integer id;
	   protected int pin;  
	   public User (Integer id) {
		// TODO Auto-generated constructor stub
		   this.id = id;
		   
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	
}
