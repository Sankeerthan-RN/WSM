package model;

import Page.DisplayGrievance;

public class Employee extends Person{
	
	
	static String userName = "employee";
	
	public Employee(){
		
		super(getUserName(),"employee");
		DisplayGrievance displayGrievance = new DisplayGrievance();
		displayGrievance.showGrievance();	
	}
	
	public static String getUserName()
	{
		return userName;
	}

}
