package university;

import javax.swing.JOptionPane;

public class Person {
	
	private String name;
	private Address adrs;

	protected Person() {
		
		this.name = JOptionPane.showInputDialog("Enter the person's name: ");
		this.adrs = new Address();
	}
	/* for hardcoded data */
	protected Person(String name, String stNum, String stName, String city, String state, String country) {
		
		this.name = name;
		this.adrs = new Address(stNum, stName, city, state, country);
	}
	
	public String getName() {
		
		return this.name;
	}
	
	protected void setName() {
		
		this.name = JOptionPane.showInputDialog("Enter new name: ");
	}
	
	public String toString() {
		
		return "Name: " + this.name + ". Address: " + adrs.toString();
	}
}
