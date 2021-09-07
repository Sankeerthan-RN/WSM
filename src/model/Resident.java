package model;


public class Resident extends Person{
	
	public  Resident(int id,String firstName,String lastName,String UserName,String Password,String Address,String Email,String ContactNo) 
    { 
		super(UserName,Password);
		
		this.id = id;

       this.firstName =  firstName ;
       
       this.lastName =  lastName ;

       this.address = Address; 

       this.number = ContactNo; 
       
       this.email = Email;
       
     } 
	
	public final int id;
	public final String firstName; 
	public final String lastName; 
	public String address; 
	public String email;
	public String number; 
}
	