package attacks;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.File;

public class AttackMonitor {

	static List<MonsterAttack> monAtks;
			
	public AttackMonitor() {
		
		monAtks = new ArrayList<MonsterAttack>();
	}
	
	public void testData(int id, String date, String monster, String location, String reporter) {
		
		monAtks.add(new MonsterAttack(id, date, monster, location, reporter));
	}
	
	public void monitor() {

		boolean loop = true;
		
		do {
			
			String[] choices = {"Create MonAtk", "Delete a MonAtk","Display MonAtks", "Save", "Load", "Quit"};
			
			int choice = JOptionPane.showOptionDialog(null, "                                             ~~~~~~~MAIN MENU~~~~~~~~", "Choice", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
					choices, choices[4]);
					
			switch (choice) {
			
				case 0: 
					
					createMonAtk();
					break;
					
				case 1: 
					
					deleteMonAtk();
					break;
					
				case 2: 
					
					displayMonAtks();
					break;
					
				case 3:
					
					
					MonsterPersister monPre = new BinaryMonsterPersister();
					
					JFileChooser jfc = new JFileChooser();

					int retVal = jfc.showOpenDialog(null);
					
					if (retVal == JFileChooser.APPROVE_OPTION) {
						
						File selectedFile = jfc.getSelectedFile();
						
						monPre.save(selectedFile, monAtks);
					}
					break;
				case 4: 
					
					MonsterPersister monPre_ = new BinaryMonsterPersister();
					
					JFileChooser jfc_ = new JFileChooser();

					int retVal_ = jfc_.showOpenDialog(null);
					
					if (retVal_ == JFileChooser.APPROVE_OPTION) {
						
						File selectedFile = jfc_.getSelectedFile();
						
						monAtks = monPre_.load(selectedFile);
					}

					break;
				case 5:
					loop = false;
				
			}
		
		} while (loop);
		
	}
	

	private void createMonAtk() {
		
		int ID = Integer.parseInt(JOptionPane.showInputDialog("Enter ID: "));
		
		String date = JOptionPane.showInputDialog("Enter the date (MM/DD/YYYY): ");
		
		String monster = JOptionPane.showInputDialog("Enter the monster's name: ");
		
		String location = JOptionPane.showInputDialog("Enter the location: ");
		
		String reporter = JOptionPane.showInputDialog("Enter the reporter's name: ");
		
		monAtks.add(new MonsterAttack(ID, date, monster, location, reporter));
		
		JOptionPane.showMessageDialog(null, "Successful ly created a new Monster Attack");
		
	}
	
	private void deleteMonAtk() {
		
		int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the monster attack: "));
		
		for (int i = 0; i < monAtks.size(); i++) {
			
			if(monAtks.get(i).getID() == id) {
				
				monAtks.remove(i);
				
				i = monAtks.size();
			}
			
		}
	}
	
	private void displayMonAtks() {
		
		String toDisplay = "";
		
		if (monAtks.size() == 0) {
			
			JOptionPane.showMessageDialog(null, "There are no monster attacks!");
			
		} else {
			
			for (int i = 0; i < monAtks.size(); i++) {
				
				toDisplay += monAtks.get(i).toString() + "\n";
			}
		}
		
		JOptionPane.showMessageDialog(null, toDisplay);
		
	}
	
//	private void saveMonAtks(String saveDir) throws IOException {
//				
//		File output = new File(saveDir);
//		
//		BufferedWriter writer = new BufferedWriter(new FileWriter(output));	
//		
//		for (int i = 0; i < monAtks.size(); i++) {
//			
//			writer.write(monAtks.get(i).getID() + "," + monAtks.get(i).getDate() + "," + monAtks.get(i).getMonsterName() + "," 
//					+ monAtks.get(i).getLocation() + "," + monAtks.get(i).getReporterName());
//			
//			writer.newLine();
//		}
//		
//		writer.close();
//		
//	}
//	
//	private void loadMonAtks(String loadDir) throws IOException {
//		
//		monAtks.clear();
//		
//		File input = new File(loadDir);
//		
//		Scanner reader = new Scanner(input);
//		
//		while(reader.hasNextLine()) {
//			
//			String[] rawData = reader.nextLine().split(",");
//			
//			int ID = Integer.parseInt(rawData[0]);
//			
//			monAtks.add(new MonsterAttack(ID, rawData[1].trim(), rawData[2], rawData[3], rawData[4]));
//			
//		}
//		
//		reader.close();
//	}
}
	
