package haunted;

import javax.swing.JOptionPane;

public class Asylum extends Building {
	
	private String name;
	
	public Asylum() {

		super();
		this.name = JOptionPane.showInputDialog("What is the Asylum's name?");
	}
	
	public Asylum(double size, boolean haunted, String name) {
		
		super(size, haunted);
		this.name = name;	
	}
	
	@Override
	public String explore() {
		
		String toReturn = "";
		
		if(super.haunted) {
			
			toReturn += "An unknown presence is felt by the explores! Proceed with caution.\n";
		}

		toReturn += "The asylum is called: " + this.name + "The asylum is " + super.getSize() + " sq. meters.\n";
		
		return toReturn;
	}
}