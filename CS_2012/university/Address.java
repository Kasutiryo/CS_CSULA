package university;

//import java.util.*;
import javax.swing.*;

public class Address {
	
	private String stNum;
	private String stName;
	private String city;
	private String state;
	private String country;
	
	protected Address() {
		
		this.stNum = JOptionPane.showInputDialog("Enter the street number: ");
		this.stName = JOptionPane.showInputDialog("Enter the street name: ");
		this.city = JOptionPane.showInputDialog("Enter the city: ");
		this.state = JOptionPane.showInputDialog("Enter the state: ");
		this.country = JOptionPane.showInputDialog("Enter the country: ");

	}
	/* for hardcoded data */
	protected Address (String stNum, String stName, String city, String state, String country) {
		
		this.stNum = stNum;
		this.stName = stName;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	
	protected String getStNum() {
		
		return this.stNum;
	}
	
	protected void setStNum() {
		
		this.stNum = JOptionPane.showInputDialog("Enter the new street number: ");
	}
	
	protected String getStName() {
		
		return this.stName;
	}
	
	protected void setStName() {
		
		this.stName = JOptionPane.showInputDialog("Enter the new street name: ");
	}
	
	protected String getCity() {
		
		return this.city;
	}
	
	protected void setCity() {
		
		this.city = JOptionPane.showInputDialog("Enter the new city: ");
	}
	
	protected String getState() {
		
		return this.state;
	}
	
	protected void setState() {
		
		this.state = JOptionPane.showInputDialog("Enter the new state: ");
	}
	
	protected String getCountry() {
		
		return this.country;
	}
	
	protected void setCountry() {
		
		this.country = JOptionPane.showInputDialog("Enter the new country: ");
	}
	
	public String toString() {
		
		return this.stNum + " " + this.stName + ", " + this.city + " " + this.state + ", " + this.country;
	}
}
