package haunted;

import java.util.*;
import javax.swing.*;

abstract class Building {
	
	protected double size;
	protected boolean haunted;
	Scanner input = new Scanner(System.in);
	
	public Building() {
		
		this.size = Integer.parseInt(JOptionPane.showInputDialog("Enter the size of the house (sq. meters): "));
		int isHaunted = Integer.parseInt(JOptionPane.showInputDialog("Is the building haunted: (0 for no, 1 for yes): "));
		
		if (isHaunted == 1) {
			
			this.haunted = true;
		} else {
			
			this.haunted = false;
		}
	}
	
	public Building(double size, boolean haunted) {
		
		this.size = size;
		this.haunted = haunted;
	}

	public abstract String explore();
	
	public String toString() {
		
		return "The building is " + this.size + " Sq. Meters. Is the house haunted? " + this.haunted;
	}
	
	public double getSize() {
		
		return this.size;
	}
	
	public void setSize() {
		
		System.out.println("Enter the new size: ");
		this.size = input.nextInt();
	}
	
	public boolean getHaunted() {
		
		return this.haunted;
	}
	
}

