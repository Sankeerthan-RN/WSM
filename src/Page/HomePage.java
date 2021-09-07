package Page;

import java.awt.*;  
import javax.swing.*;

import Panel.ConsumptionData;
import Panel.FileGrievance;
import Panel.Profile;
import model.Resident;  
 
public class HomePage {  
JFrame f;  
JPanel p1,p2,p3;
Resident resident;


public HomePage(Resident resident)
{
	this.resident = resident;
}


public void getHomePage()

{
	
	FileGrievance fg = new FileGrievance(resident);
	Profile p = new Profile(resident);
	ConsumptionData c = new ConsumptionData(resident);
    f=new JFrame("HomePage");   
    JTabbedPane tp=new JTabbedPane();
	 
    p1 = p.getPage(f); 
    p2 = fg.getPage(f);
    p3 = c.getPage(f);
      
    tp.setBounds(50,25,600,550);  
    tp.add("Profile",p1);
    p1.setBackground(Color.yellow);
    p2.setBackground(Color.cyan);
    p3.setBackground(Color.orange);
    tp.add("File Grievance",p2);  
    tp.add("Consumption Data",p3);    
    f.add(tp);  
    f.setSize(700,700);  
    f.setLayout(null);  
    f.setVisible(true); 
    f.getContentPane().setBackground(Color.lightGray);
}
}  