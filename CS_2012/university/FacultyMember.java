package university;

import java.util.*;

import javax.swing.JOptionPane;

public class FacultyMember extends Person {
	
	private String EID;
	private ArrayList<Course> schedule = new ArrayList<Course>();
	
	protected FacultyMember() {
		
		super();
		this.EID  = JOptionPane.showInputDialog("Enter the new employee's ID: ");
	}

	/* for hardcoded data */
	protected FacultyMember(String name, String stNum, String stName, String city, String state, String country, String EID) {
		
		super(name, stNum, stName, city, state, country);
		this.EID = EID;
		}
	
	protected void addCourse(Course crs) {
		
		schedule.add(crs);
	}

	protected void deleteCourse(Course crs) {
		
		schedule.remove(crs);
	}
	
	protected ArrayList<Course> getSchedule() {
		
		return this.schedule;
	}
	public String getEID() {
		
		return this.EID;
	}
	
	protected void setEID() {
		
		this.EID = JOptionPane.showInputDialog("Enter the new CIN: ");
	}
	
	public String toString() {
		
		String sch = "";
		
		for (int i = 0; i < schedule.size(); i++) {
			
			sch += schedule.get(i).getIdentifier() + " " + schedule.get(i).getUnits() + "\n";
		}
		
		return super.toString() + " Employee ID: " + this.EID + "\nCurrent Schedule:\n\t " + sch;
	}
}

