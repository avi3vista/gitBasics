package com.experiment;

public class Parent {

	String firstName;
	String lastName;
	
	public String getNames(String firstName, String lastName) {
		return "firstString";
	}
	
	
	public String getNames(String firstName) {
		return "secondString";
	}

}
