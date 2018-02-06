package Homework_10;

import java.util.Scanner;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.FileNotFoundException;

public class HW10P03 {
	
	public static void main(String[] args) {
		
		JOptionPane.showMessageDialog(null, "Please enter a text file of scores.");
		
		File data = input();
		
		getGrade(getBestScore(data), data);
		
	}
	
	public static File input() {
		
		JFileChooser jfc = new JFileChooser(".");
		
		jfc.showOpenDialog(null);
		
		File input = jfc.getSelectedFile();
		
		return input;
	}
	
	public static double getBestScore(File data) {
		
		Scanner reader = null;
		
		try {
			
			reader = new Scanner(data);
			
		} catch (FileNotFoundException e) {
			
			JOptionPane.showConfirmDialog(null, "Fine not found! Program will now exit!");
			
			System.exit(1);
		}
		
		double max = Double.parseDouble(reader.next());
		
		
		while (reader.hasNext()) {
			
			double currentNum = Double.parseDouble(reader.next());
			
			if (currentNum > max) {
				max = currentNum;
			}
		}
		
		return max;
	}

	public static void getGrade(double bestScore, File data) {
		
		Scanner reader = null;
		
		try {
			
			reader = new Scanner(data);
			
		} catch (FileNotFoundException e) {
			
			JOptionPane.showMessageDialog(null, "File not found! Program will not exit!");
			
			System.exit(1);
		}
		
		int studentCounter = 1;
		
		while (reader.hasNext()) {
			
			String grade = "F";
			
			double currentScore = reader.nextDouble();
			
			if (currentScore >= bestScore - 15) {
				
				grade = "A";
			} else if (currentScore >= bestScore - 25) {
				
				grade = "B";
			} else if (currentScore >= bestScore - 35) {
				
				grade = "C";
			} else if (currentScore >= bestScore - 45) {
				
				grade = "D";
			}
			
			String str = "Student " + studentCounter + "'s score is " + currentScore + " and their grade is " + grade + ".";
			
			System.out.println(str);
			
			studentCounter++;
		}
		
	}


}
