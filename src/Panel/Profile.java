package Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

import model.Resident;

public class Profile extends Panel{
	
	

	public Profile(Resident resident){
		
		this.resident = resident;
	}
	
	@Override
	public JPanel getPage(JFrame f)
	{
		
		
	JPanel main=new JPanel();
	JLabel l0 = new JLabel("----------------------WELCOME TO WSM PORTAL------------------------ ");
	l0.setBounds(120,10, 500,20);
	
	JLabel p1 = new JLabel("RESIDENT PROFILE");
	p1.setBounds(230,30, 500,20);

	JLabel l1 = new JLabel("NAME : ");
	l1.setBounds(20,80, 150,20);
	
	JLabel l11 = new JLabel("name : ");
	l11.setBounds(200,80, 150,20);
	
	
	JLabel l2 = new JLabel("USERNAME: ");
	l2.setBounds(20,160, 150,20);
	
	JLabel l21 = new JLabel("user ");
	l21.setBounds(200,160, 150,20);

	JLabel l3 = new JLabel("ADDRESS :");
     l3.setBounds(20,240, 150,20);
     
     JLabel l31 = new JLabel("add ");
 	l31.setBounds(200,240, 150,20);
 	
 	JTextField l32 = new JTextField("add ");
 	l32.setBounds(200,240, 150,20);
 	
	JLabel l4 = new JLabel("CONTACT NO :");
	l4.setBounds(20,320, 150,20);
	
	JLabel l41 = new JLabel("cont ");
	l41.setBounds(200,320, 150,20);
	
	JTextField l42 = new JTextField("cont ");
	l42.setBounds(200,320, 150,20);
	
	JLabel l5 = new JLabel("EMAIL ID :");
	l5.setBounds(20,400, 150,20);
	
	JLabel l51 = new JLabel("email ");
	l51.setBounds(200,400, 150,20);
	
	JTextField l52 = new JTextField("email ");
	l52.setBounds(200,400, 150,20);
	
	JButton b = new JButton("Edit");
	b.setBounds(200,450, 90,30);
	
 
     l32.setVisible(false);  
     l42.setVisible(false);  
     l52.setVisible(false);
	
	 main.setLayout(null);
	 
    main.add(p1);
	main.add(l0);
	main.add(l1);
	main.add(l11);
	main.add(l2);
	main.add(l21);
	main.add(l3);
	main.add(l31);
	main.add(l32);
	main.add(l4);
	main.add(l41);
	main.add(l42);
	main.add(l5);
	main.add(l51);
	main.add(l52);
	main.add(b);
	
	 
	 l11.setText(resident.firstName+" "+resident.lastName);
     l21.setText(resident.userName);  
     l31.setText(resident.address);  
     l41.setText(resident.number);  
     l51.setText(resident.email); 
      
     l32.setText(resident.address);  
     l42.setText(resident.number);  
     l52.setText(resident.email); 
     
    
     
     
     b.addActionListener(new ActionListener(){ 
    	 
	    	public void actionPerformed(ActionEvent e){  
	    		
	    		if(b.getText().equals("Edit"))
	    		{

		    	     l31.setVisible(false);  
		    	     l41.setVisible(false);  
		    	     l51.setVisible(false); 
		    	     

		    	     l32.setVisible(true);  
		    	     l42.setVisible(true);  
		    	     l52.setVisible(true);
		    	     
		    	     b.setText("Save");
	    		}
	    		
	    		else {
	    			
	    			String address = l32.getText();
    				String number = l42.getText();
    				String email = l52.getText();
	    			
	    			if(!address.equals(""))
	    			{
	    				try {
		    				
		    				String url="jdbc:mysql://localhost:3306/wsm";
			    			String query="UPDATE resident SET address = '"+address+"',email = '"+email+"',number = "+number+" WHERE Resident_id = "+resident.id;                         
		            		Class.forName("com.mysql.jdbc.Driver");
		            	       Connection con = DriverManager.getConnection(url,"root","");
		            	       Statement st=con.createStatement();
		            	    st.executeUpdate(query);
		            	    
		            	    resident.address = address;
		            	    resident.email = email;
		            	    resident.number = number;
		            	    
		            	     l31.setText(resident.address);  
		            	     l41.setText(resident.number);  
		            	     l51.setText(resident.email);
		            	     
		            	     l32.setText(resident.address);  
		            	     l42.setText(resident.number);  
		            	     l52.setText(resident.email); 
		            	     
		            	    
			    			
		    			}
		    			
		    			
		    			catch(Exception ex)
		    			{
		    				JOptionPane.showMessageDialog(f,"Failed to update");
		    			}
	    				
	    				
	    				 l32.setVisible(false);  
			    	     l42.setVisible(false);  
			    	     l52.setVisible(false); 
			    	     

			    	     l31.setVisible(true);  
			    	     l41.setVisible(true);  
			    	     l51.setVisible(true);
			    	     
			    	     b.setText("Edit");
		    			
	    			}
	    			
	    			else {
	    				JOptionPane.showMessageDialog(f,"fill the Address field !");
	    			}

		    	    
	    		}
 
	    	        }  
	    	    });  
	return main;
	}
}

