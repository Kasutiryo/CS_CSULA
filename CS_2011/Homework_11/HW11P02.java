package Homework_11;

import javax.swing.JOptionPane;

public class HW11P02 {

	public static void main(String[] args) {
		
		String message = "Please enter the a decimal number from 0 - 511";
		
		JOptionPane.showMessageDialog(null, printArr(generateArr(decimalToBinary(Integer.parseInt(JOptionPane.showInputDialog(null, message))))));
		
	}

	public static String decimalToBinary(int num) {
		
		String binary = "";
		
		int decimal = num;
		
		while (decimal > 0) {
			
			binary += decimal % 2;
			
			decimal = decimal / 2;
			
		}
		
		int characters = 9 - binary.length();
		
		String remaining = "";
		
		if (characters < 9) {
			
			for (int i = 0; i < characters; i++) {
				
				remaining += "0";
			}
		}
		
		binary = remaining + binary;
		
		return binary;
	}

	public static boolean[][] generateArr(String str) {
		
		boolean[][] arr = new boolean[3][3];
		
		int counter = 0;
		
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = 0; j < arr[i].length; j++) {
				
				if (str.charAt(counter) == '1') {
					
					arr[i][j] = true;
				}
				
				counter++;
			}
		}
		
		return arr;
	}

	public static String printArr(boolean[][] arr) {
	
		String str = "";
		
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = 0; j < arr[i].length; j++) {
				
				if (arr[i][j]) {
					
					str += "T  ";
					
				} else if (!arr[i][j]) {
				
					str += "F  ";
				}
			}
			
			str += "\n";
		}
		
		return str;
	}

}
