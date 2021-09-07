package Page;


import java.sql.*;
import javax.swing.*;

import model.Employee;
import model.Resident;

import java.awt.*;
import java.awt.event.*;  



public class LoginSignUp {
	
	final JFrame f;
	final JLabel unl,passl,orl,firstNamel,lastNamel,addressl,emaill,numberl;
	final JTextField unt,passt,firstNamet,lastNamet,addresst,emailt,numbert;
	JButton b;
	JLabel togglel;
	    
 public LoginSignUp() {
	    	
	    	 f = new JFrame("Login");   
	   	  unl=new JLabel("User Name* :");  
	   	  passl=new JLabel("Password* :");  
	   	firstNamel=new JLabel("First Name* :");  
	   	lastNamel=new JLabel("Last Name :");
	   	addressl=new JLabel("Address* :");  
	   	emaill=new JLabel("Email :");
	   	numberl = new JLabel("Contact No. :");
	   	unt=new JTextField();  
   	    passt=new JTextField(); 
   	 firstNamet=new JTextField();  
   	lastNamet=new JTextField();
   	addresst=new JTextField();  
   	emailt=new JTextField(); 
   	numbert=new JTextField();  
	   	  b=new JButton("Login"); 
	   	    orl = new JLabel("or");
	   	    togglel = new JLabel("Sign up");
	}
	

	public void showLoginScreen() {
		

		 unl.setBounds(20,50-3, 100,20);  
		 passl.setBounds(20,100-3, 100,20); 
		 firstNamel.setBounds(20,150-3, 100,20);  
		 lastNamel.setBounds(20,200-3, 100,20); 
		 addressl.setBounds(20,250-3, 100,20);  
		 numberl.setBounds(20,320-3, 100,20); 
		 emaill.setBounds(20,370-3, 100,20);  
		 
	    unt.setBounds(100,50, 150,20); 
	    passt.setBounds(100,100, 150,20); 
	    firstNamet.setBounds(100,150, 150,20);  
		 lastNamet.setBounds(100,200, 150,20); 
		 addresst.setBounds(100,250, 200,40);  
		 numbert.setBounds(100,320, 150,20);
		 emailt.setBounds(100,370, 150,20);
	    
	    b.setBounds(100,150,95,30);    
	    orl.setBounds(200,150,30,30);
	    togglel.setBounds(200+20,150,95,30);
	    
	    togglel.setForeground(Color.BLUE);
	    
	    firstNamel.setVisible(false);
		lastNamel.setVisible(false);
		addressl.setVisible(false);
		emaill.setVisible(false);
		numberl.setVisible(false);
		firstNamet.setVisible(false);
		lastNamet.setVisible(false);
		addresst.setVisible(false);
		emailt.setVisible(false);
		numbert.setVisible(false);
		
	    
	    b.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	    	            
	    	            String UserName,password;
	    	            UserName = unt.getText();
	    	            password = passt.getText();
	    	            String url="jdbc:mysql://localhost:3306/wsm";
    					String query;
    					
	    	            
	    	            if(b.getText().equals("Login"))
	    	            {
	    	            	
	    	            	if(!(UserName.equals(Employee.getUserName()) && password.equals("employee")))
	    	            	{
	    	            		try {
		    	            		
			    					 query= "SELECT * FROM resident WHERE userName = '"+UserName+"' AND pass='"+password+"' ";
			    					 Class.forName("com.mysql.jdbc.Driver");
			    			       Connection con = DriverManager.getConnection(url,"root","");
			    			       Statement st=con.createStatement();
			    					ResultSet rs=st.executeQuery(query);
			    				       rs.next();
			    				       int id = -1;
			    				       id = rs.getInt("Resident_id");
			    				       Resident resident = new Resident(rs.getInt("Resident_id"),rs.getString("firstName"),rs.getString("lastName"),UserName,password,rs.getString("address"),rs.getString("email"),rs.getString("number"));
			    				       if(id != -1) 
			    				    	   {
			    				    	   JOptionPane.showMessageDialog(f, "Logged in ! :) ");
			    				    	   f.dispose();
			    				   		HomePage homePage = new HomePage(resident);
			    				   		homePage.getHomePage();
			    				    	   }   
			    				}
			    				
			    				catch(Exception wx)
			    				{
			    					JOptionPane.showMessageDialog(f, "Invalid user name or password ! :( ");
			    				}
	    	            	}
	    	            	else
	    	            	{
	    	            		JOptionPane.showMessageDialog(f, "Signed in as an Employee");
	    	            		f.dispose();
	    	            		new Employee(); 

	    	            	}
	    	            }
	    	            
	    	            else {
	    	            	String firstName,lastName,address,email,number;
	    	            	firstName = firstNamet.getText();
	    	            	lastName = lastNamet.getText();
	    	            	address = addresst.getText();
	    	            	email = emailt.getText();
	    	            	number = numbert.getText();
	    	            	if(!UserName.equals("employee"))
	    	            	{
	    	            		if(!UserName.equals("") && !password.equals("") && !firstName.equals("")&& !address.equals(""))
	    	            		{
	    	            			try {
	    	    	            		query="INSERT INTO resident(firstName,lastName,userName,pass,address,email,number)  VALUES('"+firstName+"','"+lastName+"','"+UserName+"','"+password+"','"+address+"','"+email+"','"+number+"')";                         
	    	    	            		Class.forName("com.mysql.jdbc.Driver");
	    	    	            	       Connection con = DriverManager.getConnection(url,"root","");
	    	    	            	       Statement st=con.createStatement();
	    	    	            	    st.executeUpdate(query);
	    	    	            	    query = "SELECT * FROM resident WHERE userName = '"+UserName+"' AND pass='"+password+"' AND email = '"+email+"'";
	    	    	            	    ResultSet rs=st.executeQuery(query);
	    		    				       rs.next();
	    		    				       
	    		    				       Resident resident = new Resident(rs.getInt("Resident_id"),"u",rs.getString("lastName"),UserName,password,rs.getString("address"),rs.getString("email"),rs.getString("number"));
	    	    	            	    JOptionPane.showMessageDialog(f,"Registration Succesful ! :) ");
	    	    	            	    f.dispose();
	    	    	            	    HomePage homePage = new HomePage(resident);
	    	    				   		homePage.getHomePage();
	    	    	            	    
	    		    				    	   
	    		    				}
	    		    				
	    		    				catch(Exception wx)
	    		    				{
	    		    					JOptionPane.showMessageDialog(f,"Registration Failed !:( "+wx);
	    		    					
	    		    				}
	    	            		}
	    	            		else {
	    	            			JOptionPane.showMessageDialog(f,"All the required fields (*) are must  ");
	    	            		}
	    	            	
	    	            	}
	    	            	else {
	    	            		JOptionPane.showMessageDialog(f,"This UserName is not allowed, try another ");
	    	            	}
	    	            }
	    	            
	    	            
	    	            
	    	        }  
	    	    });  
	    
	    togglel.addMouseListener(new MouseAdapter()  
	    {  
	        public void mouseClicked(MouseEvent e)  
	        {  
	        	boolean flag;
	        	
	        	if(b.getText().equals("Login"))
	        	{
	        		b.setText("Sign up");
		        	togglel.setText("Login");
		        	flag = true;
		        	
	        	}
	        	else {
	        		togglel.setText("Sign up");
		        	b.setText("Login");
		        	flag = false;
	        	}
	        	
	        	firstNamel.setVisible(flag);
	    		lastNamel.setVisible(flag);
	    		addressl.setVisible(flag);
	    		emaill.setVisible(flag);
	    		numberl.setVisible(flag);
	    		firstNamet.setVisible(flag);
	    		lastNamet.setVisible(flag);
	    		addresst.setVisible(flag);
	    		emailt.setVisible(flag);
	    		numbert.setVisible(flag);
	    		
	    		
	    		if(flag) {
	    			b.setBounds(100,420,95,30);
	    			orl.setBounds(200,420,30,30);
	    		    togglel.setBounds(200+20,420,95,30);
	    		}
	    			
	    		else {
	    			b.setBounds(100,150,95,30);
	    			orl.setBounds(200,150,30,30);
	    		    togglel.setBounds(200+20,150,95,30);
	    		}
	        }  
	    }); 
	     

	    	f.add(unt);  
		    f.add(passt);
		    f.add(b);
		    f.add(unl);
		    f.add(passl);
		    f.add(togglel);
		    f.add(orl);
		    f.add(firstNamet);
		    f.add(lastNamet);
		    f.add(emailt);
		    f.add(numbert);
		    f.add(addresst);
		    f.add(firstNamel);
		    f.add(lastNamel);
		    f.add(emaill);
		    f.add(numberl);
		    f.add(addressl);

	    
	    
	    f.getContentPane().setBackground(Color.cyan);
//	    unl.setOpaque(true);
	    unl.setForeground(new Color(120, 90, 40));
	    passl.setForeground(new Color(120, 90, 40));
//	      unl.setBackground(new Color(100, 20, 70));

	    
	    f.setSize(500,600);  
	    f.setLayout(null);  
	    f.setVisible(true);   
	}
}
