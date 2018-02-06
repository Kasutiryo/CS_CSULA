package university;

import java.util.*;

import javax.swing.JOptionPane;

public class Student extends Person {
	
	private String CIN;
	private ArrayList<Course> schedule = new ArrayList<Course>();
	
	protected Student() {
		
		super();
		this.CIN  = JOptionPane.showInputDialog("Enter the student's CIN: ");
	}

	/* for hardcoded data */
	protected Student(String name, String stNum, String stName, String city, String state, String country, String CIN) {
		
		super(name, stNum, stName, city, state, country);
		this.CIN = CIN;
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
	public String getCIN() {
		
		return this.CIN;
	}
	
	protected void setCIN() {
		
		this.CIN = JOptionPane.showInputDialog("Enter the new CIN: ");
	}
	
	public String toString() {
		
		String sch = "";
		
		for (int i = 0; i < schedule.size(); i++) {
			
			sch += schedule.get(i).getIdentifier() + " " + schedule.get(i).getUnits() + "\n";
		}
		
		return super.toString() + " CIN: " + this.CIN + "\nCurrent Schedule: " + sch;
	}
}
