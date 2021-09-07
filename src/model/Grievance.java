package model;

public class Grievance {
	
	public Grievance(int Grievance_Id,int Resident_Id,String date,String Description,String Suggestion)
	{
		this.Grievance_Id = Grievance_Id;
		this.Resident_Id = Resident_Id;
		this.date = date;
		this.Description = Description;
		this.Suggestion = Suggestion;
	}
	
	public final int Grievance_Id;
	public final int Resident_Id;
	public final String date;
	public final String Description;
	public final String Suggestion;
	
}
