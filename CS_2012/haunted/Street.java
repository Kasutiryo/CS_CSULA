package haunted;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Street {

	protected String name;
	protected ArrayList<Building> bList = new ArrayList<Building>();
	
	public Street(String name) {
		
		this.name = name;
	}
	
	public String getName() {
		
		return this.name;
	}
	
	public void addAsylum(double size, boolean haunted, String name) {
		
		bList.add(new Asylum(size, haunted, name));	
	}
	
	public void addHouse(double size, boolean haunted, String name) {
		
		bList.add(new House(size, haunted, name));
	}
	
	public String getHauntedNum() {
		
		int counter = 0;
		
		for (int i = 0; i < bList.size(); i++) {
			
			if (bList.get(i).getHaunted()) {
				
				counter++;
			}
			
		}
		
		return "There are " + counter + " haunted houses on " + this.name;
	}
	
	public void stroll() {
		
		String toPrint = "Let's go for a stroll on" + this.name + "\n";
		
		for (int i = 0; i < bList.size(); i++) {
			
			toPrint += bList.get(i).explore() + "\n";
		}
		
		toPrint += this.getHauntedNum();
		
		JOptionPane.showMessageDialog(null, toPrint);
	}
}
