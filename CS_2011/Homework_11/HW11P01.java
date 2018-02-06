package Homework_11;

import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

class HW11P01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean keepRunning = true;

		while (keepRunning) {

			switch (menu()) {

			case 1:

				int[][] arr = generateRandomArr();

				JOptionPane.showMessageDialog(null, printArr(arr));

				JOptionPane.showMessageDialog(null, sumArr(arr));

				JOptionPane.showMessageDialog(null, sumRow(arr));

				JOptionPane.showMessageDialog(null, sumCol(arr));

				JOptionPane.showMessageDialog(null, sumMM(major(arr), minor(arr), arr));

				break;

			case 2:

				int[][] array = generateArrIO();

				JOptionPane.showMessageDialog(null, printArr(array));

				JOptionPane.showMessageDialog(null, sumArr(array));

				JOptionPane.showMessageDialog(null, sumRow(array));

				JOptionPane.showMessageDialog(null, sumCol(array));

				JOptionPane.showMessageDialog(null, sumMM(major(array), minor(array), array));

				break;
			case 3:

				String exit = "The program will now self-destruct!";

				JOptionPane.showMessageDialog(null, exit);

				keepRunning = false;

				break;

			default:

				String error = "Something went wrong! Program will now self-destruct!";

				JOptionPane.showMessageDialog(null, error, "~~~WARNING~~~", JOptionPane.ERROR_MESSAGE);

				keepRunning = false;
			}
		}
	}

	public static int menu() {

		String message = "Choose one:\n" + "Option 1: Generate Random 2D array\n"
				+ "Option 2: Populate an array using File I/O\n" + "Option 3: Exit Program";

		return Integer.parseInt(JOptionPane.showInputDialog(null, message));
	}

	public static int[][] generateRandomArr() {

		String messageROW = "How many rows in the array?";

		int row = Integer.parseInt(JOptionPane.showInputDialog(null, messageROW));

		String messageCOL = "How many columns in the array?";

		int col = Integer.parseInt(JOptionPane.showInputDialog(null, messageCOL));

		String messageMIN = "Enter a minimum value to be generated:";

		int min = Integer.parseInt(JOptionPane.showInputDialog(null, messageMIN));

		String messageMAX = "Enter a maximum value to be generated:";

		int max = Integer.parseInt(JOptionPane.showInputDialog(null, messageMAX));

		int[][] randomArr = new int[row][col];

		for (int i = 0; i < row; i++) {

			for (int j = 0; j < col; j++) {

				randomArr[i][j] = min + (int) (Math.random() * (max - min + 1));
			}
		}

		return randomArr;
	}

	public static String printArr(int[][] arr) {

		String str = "";

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length; j++) {

				str += arr[i][j] + "  ";
			}

			str += "\n";
		}

		return str;

	}

	public static int[][] generateArrIO() {

		JFileChooser jfc = new JFileChooser(".");

		jfc.showOpenDialog(null);

		File data = jfc.getSelectedFile();

		Scanner reader = null;

		try {

			reader = new Scanner(data);

		} catch (FileNotFoundException e) {

			JOptionPane.showMessageDialog(null, "File not found!");

		}

		int row = reader.nextInt();

		int col = reader.nextInt();

		String messageMIN = "Enter a minimum value to be generated:";

		int min = Integer.parseInt(JOptionPane.showInputDialog(null, messageMIN));

		String messageMAX = "Enter a maximum value to be generated:";

		int max = Integer.parseInt(JOptionPane.showInputDialog(null, messageMAX));

		int[][] randomArr = new int[row][col];

		while (reader.hasNext()) {

			for (int i = 0; i < randomArr.length; i++) {

				for (int j = 0; j < randomArr[i].length; j++) {

					randomArr[i][j] = min + (int) (Math.random() * (max - min + 1));
				}
			}
		}

		return randomArr;

	}

	public static String sumArr(int[][] arr) {

		double sum = 0.0;

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length; j++) {

				sum += arr[i][j];

			}
		}

		double avg = sum / (double) (arr.length * arr[0].length);

		String str = "The sum for the entire array is: " + sum + ".\n" + "The average of the sum of the entire array "
				+ avg + ".\n";

		return str;
	}

	public static String sumRow(int[][] arr) {

		String str = "";

		double max = 0;

		double min = 1000000000;

		String highest = "";

		String lowest = "";

		for (int i = 0; i < arr.length; i++) {

			double sum = 0.0;

			double avg = 0.0;

			for (int j = 0; j < arr[i].length; j++) {

				sum += arr[i][j];
			}

			avg = sum / (double) arr[i].length;

			if (avg > max) {

				highest = "" + i;

				max = avg;
			}
			if (avg < min) {

				lowest = "" + i;

				min = avg;
			}

			str += "The sum for row " + i + " is: " + sum + ".\n" + "The average for row " + i + " is: " + avg + ".\n";
		}

		str += "The row with the highest value is: " + highest + " with a average of " + max + ".\n"
				+ "The row with the lowest value is: " + lowest + " with a average of " + min + ".";

		return str;
	}

	public static String sumCol(int[][] arr) {

		String str = "";

		double max = 0;

		double min = 1000000000;

		String highest = "";

		String lowest = "";

		for (int j = 0; j < arr[0].length; j++) {

			double sum = 0;

			double avg = 0.0;

			for (int i = 0; i < arr.length; i++) {

				sum += arr[i][j];
			}

			avg = sum / (double) arr.length;

			if (avg > max) {

				highest = "" + j;

				max = avg;
			}

			if (avg < min) {

				lowest = "" + j;

				min = avg;
			}

			str += "The sum of column " + j + " is: " + sum + ".\n" + "The average of the same column is: " + avg
					+ ".\n";
		}

		str += "The column with the highest value is: " + highest + " with a average of " + max + ".\n"
				+ "The column with the lowest value is: " + lowest + " with a average of " + min + ".";

		return str;
	}

	public static double major(int[][] arr) {

		double sum = 0;

		int diagonals = 0;

		if (arr.length <= arr[0].length) {

			diagonals = arr.length;
		} else {

			diagonals = arr[0].length;
		}

		for (int i = 0; i < diagonals; i++) {

			for (int j = i; j == i; j++) {

				sum += arr[i][j];

			}
		}

		return sum;
	}

	public static double minor(int[][] arr) {

		int sum = 0;

		int diagonals = 0;

		if (arr.length <= arr[0].length) {

			diagonals = arr.length;
		} else {

			diagonals = arr[0].length;
		}

		for (int i = 0; i < diagonals; i++) {

			for (int j = arr.length - 1 - i; j == arr.length - 1 - i; j--) {

				sum += arr[i][j];
			}
		}

		return sum;

	}

	public static String sumMM(double major, double minor, int[][] arr) {

		double sum = major + minor;

		double diagonals = 0;

		if (arr.length <= arr[0].length) {

			diagonals = arr.length;
		} else {

			diagonals = arr[0].length;
		}

		String str = "The sum of the the major diagonals and minor diagonals is: " + sum + ".\n"
				+ "The average of these diagonals is: " + (sum / diagonals);

		return str;

	}

	
}
