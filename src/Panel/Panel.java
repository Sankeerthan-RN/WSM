package Panel;
import javax.swing.*;

import model.Resident;

public abstract class Panel {

	public Resident resident;
	
	abstract public JPanel getPage(JFrame f);
	
}
