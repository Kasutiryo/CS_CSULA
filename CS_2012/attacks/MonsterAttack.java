package attacks;

import javax.swing.JOptionPane;
import java.io.Serializable;

public class MonsterAttack implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ID;
	private String month;
	private String day;
	private String year;
	private String monster;
	private String location;
	private String reporter;
	
	public MonsterAttack() {
	
	}
	
	public MonsterAttack(int id, String date, String monster, String location, String reporter) {
	
		this.ID = id;
		this.monster = monster;
		this.location = location;
		this.reporter = reporter;
		
		boolean loop = true;
		
		do {
		
		if (date.length() < 8 || date.length() > 10) {
			
			date = JOptionPane.showInputDialog("Wrong date format, try again!\nEnter the new date (MM/DD/YYYY): ");
		} else {
			loop = false;
			}
		}
		while (loop);

		String[] arr = date.split("/");
		
		this.month = arr[0];
		this.day = arr[1];
		this.year = arr[2];
		
	}
	
	public void setID() {
		
		this.ID = Integer.parseInt(JOptionPane.showInputDialog("Enter the new ID: "));
	}
	
	public int getID() {
				
		return this.ID;
	}
	
	public String getDate() {
			
		return month + "/" + day + "/" + year;
	}
	
	public void setDate() {
		
		String newDate = JOptionPane.showInputDialog("Enter the new date (MM/DD/YYYY): ");
		
		boolean loop = true;
		
		do {
			
			if (newDate.length() < 8 || newDate.length() > 10) {
				
				newDate = JOptionPane.showInputDialog("Wrong date format, try again!\nEnter the new date (MM/DD/YYYY): ");
			
			} else {
				loop = false;
				}
			}
			while (loop);

			String[] arr = newDate.split("/");
			
			this.month = arr[0];
			this.day = arr[1];
			this.year = arr[2];
		
	}
	
	public void setMonsterName() {
		
		this.monster = JOptionPane.showInputDialog("Enter the new name for the monster: ");
	}
	
	public String getMonsterName() {
				
		return this.monster;
	}
	
	public void setLocation() {
		
		this.location = JOptionPane.showInputDialog("Enter the new location of the attack: ");
	}
	
	public String getLocation() {
				
		return this.location;
	}
	
	public void setReporterName() {
		
		this.reporter = JOptionPane.showInputDialog("Enter the reporter's new name: ");	
	}
	
	public String getReporterName() {
				
		return this.reporter;
	}

	public String toString() {
		
		return "Attack #" + ID + ":" + monster + " attacked " + location + " on "
				+ this.getDate() + ". Reported by " + reporter;
	}
}
