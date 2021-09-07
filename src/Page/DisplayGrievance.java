package Page;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

import model.Grievance;

public class DisplayGrievance {
	JFrame f;
	JLabel l,l0,l1,l2,l3,l11,l21,l31;

	Grievance grievance[];
	
	public DisplayGrievance()
	{
		f = new JFrame();
		 l0 = new JLabel("---------------------- GRIEVANCE RECORDED ------------------------ ");
		 l0.setBounds(120, 10, 500, 20);
		
	       f.setSize(950,750);  
	       f.setLayout(null);  
	       f.setVisible(true);
	       f.getContentPane().setBackground(Color.orange);
	       
	       grievance = new Grievance[10];
		
		getGrievance();
	}
	
	
	public void showGrievance()
	{
		int i=0,j=115;
		
		
		if(grievance == null) {
			
			l0 = new JLabel("---------------------- NO GRIEVANCE RECORDED ------------------------ ");
			 l0.setBounds(120, 10, 500, 20);
			 
			 f.add(l0);
			 
		}
		else
		{
			l0 = new JLabel("---------------------- GRIEVANCE RECORDED ------------------------ ");
			 l0.setBounds(120, 10, 500, 20);
			 
			 f.add(l0);
			 
			for(Grievance g:grievance)
			{
				try {
					if(g != null)
					{
						l = new JLabel((i+1)+")");
						 l.setBounds(10,50+ i*j, 150,20);
						  l11 = new JLabel("Complaint Description : ");
							l11.setBounds(30,50+ i*j, 150,20);
							 l21 = new JLabel("Date (dd/MM/yyyy) : ");
							l21.setBounds(30,80+ i*j, 150,20);
							 l31= new JLabel("Suggestions :");
							l31.setBounds(30,110+ i*j, 150,20);
						 
						  l1 = new JLabel(g.Description);
							l1.setBounds(200,50 + i*j, 600,20);
						  l2 = new JLabel(g.date);
							l2.setBounds(200,80 + i*j, 150,20);
						  l3 = new JLabel(g.Suggestion);
							l3.setBounds(200,110 + i*j, 600,20);
					}
				}
				catch(Exception ex)
				{
					
				}
					
					i++;
					
				  
				  f.add(l);
				  f.add(l1);
				  f.add(l2);
				  f.add(l3);
				  f.add(l11);
				  f.add(l21);
				  f.add(l31);
			}
		}
		
		f.add(l0);
	}
	
	public void getGrievance()
	{
		try {
			
			String url="jdbc:mysql://localhost:3306/wsm";
			String query= "SELECT * FROM grievance";
			 Class.forName("com.mysql.jdbc.Driver");
	       Connection con = DriverManager.getConnection(url,"root","");
	       Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			
			
			int i=0;
		       
			 while(rs.next()) 
		       {

				 grievance[i] = new Grievance(rs.getInt("Grievance_id"),rs.getInt("Resident_id"),rs.getString("date"),rs.getString("cd"),rs.getString("cs"));
				
				 i++;
		       }
			
		       
		}
		catch(Exception e)
		{
			 
			 JOptionPane.showMessageDialog(f, " No record found ");
	
		}
		
	}
	
	
}
