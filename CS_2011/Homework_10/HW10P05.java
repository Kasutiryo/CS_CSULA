package Homework_10;

import javax.swing.JOptionPane;

public class HW10P05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] arr = {"_","_","_","_","_","_","_","_","_","_"};
		
		printArr(algorithum(arr.length));
		
		
		
		
		
		//JOptionPane.showMessageDialog(null, printArr(algorithum(arr)));
	}

	public static String[] createSeats() {

		int numberOfSeats = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of seats!"));
		
		String[] str = new String[numberOfSeats];
		
		for (int i = 0; i < str.length; i++) {
			
			str[i] = "_";
		}
		
		return str;
	}
	
	public static String printArr(String[] arr) {
		
		String str = "";
		
		for (int i = 0; i < arr.length; i++) {
			str += arr[i] + " ";
		}
		
		return str;
	}
	
	public static String printArr(boolean[] arr) {
		
		String str = "";
		
		for (int i = 0; i < arr.length; i++) {
			str += arr[i] + " ";
		}
		
		return str;
	}

	public static boolean[] algorithum(int num) {
		
		boolean[] seats = new boolean[num];
		
		int middleSeat = seats.length / 2;
		
		int leftCounter = 0;
		
		int rightCounter = 0;
		
		seats[seats.length / 2] = true;
		
		for (int i = num, greater = 0; i != 0; i--) {
			
			for (int j = middleSeat; j < seats.length; j++) {
				
				
			}
		}
		
		
		
		return seats;
	}
}
