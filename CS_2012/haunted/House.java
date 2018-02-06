package haunted;

import javax.swing.JOptionPane;

public class House extends Building {
	
	private String sFeature;
	
	public House() {
		super();
		this.sFeature = JOptionPane.showInputDialog("What is the house's special feature?");
	}
	
	public House(double size, boolean haunted, String sFeature) {
		
		super(size, haunted);
		this.sFeature = sFeature;	
	}
	
	@Override
	public String explore() {
		
		String toReturn = "";
		
		if(super.haunted) {
			
			toReturn += "An unknown presence is felt by the explores! Proceed with caution.\n";
		}
		
		toReturn += "The house is " + super.getSize() + " sq. meters. Its special feature is: " + this.sFeature + "\n";
		
		return toReturn;
	}

}