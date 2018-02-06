package university;

import javax.swing.*;

public class Course {

	private String identifier;
	private int units;
	
	protected Course() {
		
		this.identifier = JOptionPane.showInputDialog("Enter course identifier: ");
		this.units = Integer.parseInt(JOptionPane.showInputDialog("Enter the units for this course: "));
	}
	/* for hardcoded data */
	protected Course(String identifier, int units) {
		
		this.identifier = identifier;
		this.units = units;
	}
	
	public String getIdentifier() {
		
		return this.identifier;
	}
	
	protected void setidentifier() {
		
		this.identifier = JOptionPane.showInputDialog("Enter the new identifier: ");
	}
	
	public int getUnits() {
		
		return this.units;
	}
	
	protected void setUnits() {
		
		this.units = Integer.parseInt(JOptionPane.showInputDialog("Enter the new number of units: "));
	}
	
	public String toString() {
		
		return this.identifier + " Units: " + this.units;
	}
}
