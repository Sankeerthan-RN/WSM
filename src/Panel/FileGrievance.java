package Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.text.NumberFormatter;

import model.Resident;

public class FileGrievance extends Panel{
	
	String cd,cs,date;
	
public FileGrievance(Resident resident){
		
		this.resident = resident;
	}
	

	@Override
	public JPanel getPage(JFrame f)
	{
		
		JPanel p1=new JPanel();
		
		JLabel l1 = new JLabel("Complaint Description : ");
		l1.setBounds(20,50, 150,20);
		JLabel l2 = new JLabel("Date (dd/MM/yyyy) : ");
		l2.setBounds(20,150, 150,20);
		JLabel l3 = new JLabel("Suggestions :");
		l3.setBounds(20,200, 150,20);
		JTextField t1= new JTextField();
		t1.setBounds(180,50, 400,80);
	    JTextField t2= new JTextField();
	    t2.setBounds(180,150, 150,20);
	    JTextField t3= new JTextField();
	    t3.setBounds(180,200, 400,80);
	    JTextField t4= new JTextField();
	    t4.setBounds(180,100, 150,20);
	    JButton b = new JButton("SEND"); 
	    b.setBounds(200,320,95,30);  
	    
	    SpinnerModel value =  
	             new SpinnerNumberModel(1, //initial value  
	                1, //minimum value  
	                31, //maximum value  
	                1); //step  
	    JSpinner spinner1 = new JSpinner(value);   
	            spinner1.setBounds(180,150,50,30);   
	            
	             value =  
	   	             new SpinnerNumberModel(1, //initial value  
	   	                1, //minimum value  
	   	                12, //maximum value  
	   	                1); //step  
	   	    JSpinner spinner2 = new JSpinner(value);   
	   	            spinner2.setBounds(240,150,50,30);
	   	            
	   	          value =  
	   		             new SpinnerNumberModel(2020, //initial value  
	   		                2000, //minimum value  
	   		                2020, //maximum value  
	   		                1); //step  
	   		    JSpinner spinner3 = new JSpinner(value);   
	   		            spinner3.setBounds(300,150,50,30);
	   		            
	   		         JFormattedTextField txt1 = ((JSpinner.NumberEditor) spinner3.getEditor()).getTextField();
	   		      ((NumberFormatter) txt1.getFormatter()).setAllowsInvalid(false);
	   		      
	   		   JFormattedTextField txt2 = ((JSpinner.NumberEditor) spinner2.getEditor()).getTextField();
	   		      ((NumberFormatter) txt2.getFormatter()).setAllowsInvalid(false);
	   		      
	   		   JFormattedTextField txt3 = ((JSpinner.NumberEditor) spinner1.getEditor()).getTextField();
	   		      ((NumberFormatter) txt3.getFormatter()).setAllowsInvalid(false);
	    
	    
	    p1.setLayout(null);
	    
	   
	    p1.add(l1);
	    p1.add(l2);
	    p1.add(l3);
	    p1.add(t1);
	    p1.add(t3);
	    p1.add(spinner1);
	    p1.add(spinner2);
	    p1.add(spinner3);
	    p1.add(b);
	    b.addActionListener(new ActionListener(){ 
	    public void actionPerformed(ActionEvent e){  
             
	    try {
	    	cd = t1.getText();
	        cs = t3.getText();
	        int d1 = (Integer) spinner1.getValue();
	        int d2 = (Integer) spinner2.getValue();
	        int d3 = (Integer) spinner3.getValue();
	        date = d1+"/"+d2+"/"+d3;

	    String url="jdbc:mysql://localhost:3306/wsm";	
	    String query="INSERT INTO grievance(cd,date,cs,Resident_id)  VALUES('"+cd+"', '"+date+"','"+cs+"','"+resident.id+"')";
		Class.forName("com.mysql.jdbc.Driver");
       Connection con = DriverManager.getConnection(url,"root","");
       Statement st=con.createStatement();
    st.executeUpdate(query);
    
    t1.setText("");
    t3.setText("");
    spinner1.setValue(1);
    spinner2.setValue(1);
    spinner3.setValue(2020);
    
    JOptionPane.showMessageDialog(f, "Grievance filed successfully ! :) ");
			
	    }
	    catch(Exception excep)
		{
	    	JOptionPane.showMessageDialog(f, "Couldn't submit your grievance :( ");
		}
	    
	    }
	    });
	    
	    return p1; 
	}
}