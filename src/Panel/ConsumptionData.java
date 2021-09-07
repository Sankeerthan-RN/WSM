package Panel;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Resident;

public class ConsumptionData extends Panel {
	
	 HashMap<String, String> map;
	 DecimalFormat dec;
     
	
public ConsumptionData(Resident resident){
		
		this.resident = resident;
		map = new HashMap<String, String>(); 
		dec = new DecimalFormat("#0.00");
	}

public JPanel getPage(JFrame f)
{
	JPanel p=new JPanel();
	JLabel l0 = new JLabel("---------------------Consumption Data------------------------ ");
	l0.setBounds(120,10, 500,20);
	

	JLabel l1 = new JLabel("Resident Name: ");
	l1.setBounds(20,80, 150,20);
	
	JLabel l5 = new JLabel(resident.firstName+" "+resident.lastName);
	l5.setBounds(160,80, 150,20);
	
	JLabel l2 = new JLabel("Select a Month");
	l2.setBounds(20,130, 150,20);
	
	
	JLabel l3 = new JLabel("");
	l3.setBounds(350,130, 150,20);

	JLabel l4 = new JLabel("Average Consumption :");
	l4.setBounds(20,180, 150,20);
	
	JLabel l6 = new JLabel("Average Consumption");
	l6.setBounds(160,180, 150,20);
	
	
	
	
	String Month[]={"JAN","FEB","MAR","APR","MAY","JUN","JULY","AUG","SEP","OCT","NOV","DEC"};  
	
    JComboBox cb=new JComboBox(Month);
    
    
    
    cb.setBounds(160,130, 150,20);    
    p.add(cb);  
    p.add(l0);
    p.add(l1);
    p.add(l2);
    p.add(l3);
    p.add(l4);
    p.add(l5);
    p.add(l6);
    
    
    ItemListener itemListener = new ItemListener() {
    	
        public void itemStateChanged(ItemEvent itemEvent) {
        	
        	l3.setText(map.get((String) itemEvent.getItem()));
        }
      };

      
      
      cb.addItemListener(itemListener);

  
    
    String url="jdbc:mysql://localhost:3306/wsm";
	String query;
	try {
		 query= "SELECT * FROM consumption WHERE Resident_id='"+resident.id+"'" ;
		 Class.forName("com.mysql.jdbc.Driver");
       Connection con = DriverManager.getConnection(url,"root","");
       Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		double c = 0.0;
		 while(rs.next()) {
			  c+=rs.getDouble("totalConsumption");
			  map.put(rs.getString("month"), rs.getDouble("totalConsumption")+" L");
		 }
		 
		 l3.setText(map.get("JAN"));
		 c = c/map.size();
		 l6.setText(dec.format(c)+" L");
		 
	       
	}
    
	catch(Exception e)
	{
		System.out.println(e);
	}
    p.setLayout(null);    
    p.setSize(400,500);    
    p.setVisible(true);         
	
	return p;
}
	
}