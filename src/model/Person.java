package model;

public class Person {
	
	public final String userName; 
	
	private final String password;
	
	public Person(String userName,String password) {
		
		this.userName = userName;
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
}
