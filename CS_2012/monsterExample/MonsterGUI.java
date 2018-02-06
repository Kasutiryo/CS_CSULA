package monsterExample;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MonsterGUI {
	MonsterHerd herd;
	JFrame frame = null;
	JPanel panel;
	JMenuBar menubar;
	JScrollPane scrollPane;
	JTable table;
	public MonsterGUI() {
		herd = new MonsterHerd();
		initUI();
	}
	
	public final void initUI() {
		frame = new JFrame();
		panel = new JPanel();
		table = setUpTable();
				
		menubar = new JMenuBar();
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		final JFileChooser fc = new JFileChooser();

		// enums like KeyEvent evaluate to ints
		createAndAddMenuItem(file, "Open", KeyEvent.VK_O, "Open File",
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						int retVal = fc.showOpenDialog(frame);
						if (retVal == JFileChooser.APPROVE_OPTION) {
							File selectedFile = fc.getSelectedFile();
							MonsterHerdPersister p = new MonsterHerdPersister();
							herd = p.readHerdFromFile(selectedFile);
							updateTable();	
						}
					}
				});

		
		
		createAndAddMenuItem(file, "Add Monster", KeyEvent.VK_A, "Add Monster",
			new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					String name = JOptionPane.showInputDialog(frame, 							"please enter the monster's name");
					String hometown = 									JOptionPane.showInputDialog(frame,								"please enter the monster's hometown");
					String rampage = JOptionPane
						.showInputDialog(frame,
						"what does the monster do when it goes on a rampage?");
							
						Monster m = new Monster(name, hometown, rampage);
							herd.addMonster(m);
							updateTable();			
							
						}
					});
		createAndAddMenuItem(file, "Save", KeyEvent.VK_S, "Save File",
			new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					int retVal = fc.showOpenDialog(frame);
					if (retVal == JFileChooser.APPROVE_OPTION) {
						File selectedFile = fc.getSelectedFile();
						MonsterHerdPersister p = new MonsterHerdPersister();
						p.saveHerdToFile(selectedFile, herd);
					}
				}
			});

		
		createAndAddMenuItem(file, "Exit", KeyEvent.VK_E, "Exit application",
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						System.exit(0);
					}
				});

		menubar.add(file);
		frame.setJMenuBar(menubar);

		frame.setTitle("Monsters");
		frame.setSize(600, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		scrollPane = new JScrollPane(table);
		panel.add(scrollPane);
		frame.add(panel);
		frame.setVisible(true);
	}


	private void createAndAddMenuItem(JMenu menu, String message, int mnemonic,
			String tooltip, ActionListener a) {
		JMenuItem menuItem = new JMenuItem(message);
		menuItem.setMnemonic(mnemonic);
		menuItem.setToolTipText(tooltip);
		menuItem.addActionListener(a);
		menu.add(menuItem);
	}

	
	private JTable setUpTable(){
		String[] columnNames = { "Name", "Hometown", "Rampage Behavior"};
		Object[][] data = listToArray(herd.getMonsters());
		JTable newTable = new JTable(data, columnNames);
		newTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
		newTable.setFillsViewportHeight(true);
		newTable.setAutoCreateRowSorter(true);
		newTable.doLayout();
		return newTable;
	}

	private void updateTable() {
		for (Monster m : herd.getMonsters())
			System.out.println(m);
		panel.removeAll();
		table = setUpTable();
		scrollPane = new JScrollPane(table);
		panel.add(scrollPane);
		panel.doLayout();		
	}

	private Object[][] listToArray(List<Monster> list) {
		Object[][] array = new Object[list.size()][3];
		for (int counter = 0; counter < list.size(); counter++) {
			array[counter][0] = list.get(counter).getName();
			array[counter][1] = list.get(counter).getHometown();
			array[counter][2] = list.get(counter).getRampageBehavior();
			
		}
		return array;
	}
	

	public static void main(String[] args) {
		MonsterGUI ex = new MonsterGUI();
	}
}

	

