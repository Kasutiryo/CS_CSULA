package Homework_11;

public class HW11P03 {
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			while (true) {
				
			String[][] arr = generateArr((Integer.parseInt(javax.swing.JOptionPane.showInputDialog(null, "Enter matrix size:"))));
			
			javax.swing.JOptionPane.showMessageDialog(null, printArr(arr));
			
			javax.swing.JOptionPane.showMessageDialog(null, checkRows(arr));
			
			javax.swing.JOptionPane.showMessageDialog(null, checkCols(arr));
			
			javax.swing.JOptionPane.showMessageDialog(null, checkMajorLeft(arr));
			
			javax.swing.JOptionPane.showMessageDialog(null, checkMajorRight(arr));
			
			}

		}
		public static String[][] generateArr(int num) {
			
			String[][] arr = new String[num][num];
			
			java.util.Random r = new java.util.Random();
			
			for (int i = 0; i < arr.length; i++) {
				
				for (int j = 0; j < arr[i].length; j++) {
					
					int ran = r.nextInt(2);
					
					if (ran == 0) {
						
						arr[i][j] = "o";
					
					} else {
						
						arr[i][j] = "x";
					}
				}
			}
			
			return arr;
		}
		
		public static String printArr(String[][] arr) {
			
			String str = "";
			
			
			for (int i = 0; i < arr.length; i++) {
				
				for (int j = 0; j < arr[i].length; j++) {
					
					str += arr[i][j] + " ";
				}
				
				str += "\n";
			}
			
			return str;
		}
		
		public static String checkRows(String[][] arr) {
			
			String str = "";
			
			String x = "";
			
			String o = "";
			
			for (int i = 0; i < arr.length; i++) {
				
				x += "x";
				
				o += "o";
			}
			
			for (int i = 0; i < arr.length; i++) {
				
				String checking = "";
				
				for (int j = 0; j < arr[i].length; j++) {
					
					checking += arr[i][j];
					
				}
				
				if (checking.equals(x)) {
					
					str += "All x's in row " + (i + 1) + ".\n";
				} else if (checking.equals(o)) {
					
					str += "All o's in row " + (i + 1) + ".\n";
				}
			}
			
			if (str.equals("")) {
				return "There isn't any winning rows!";
			}
			
			return str;

		}

		public static String checkCols(String[][] arr) {
			
			String str = "";
			
			String x = "";
			
			String o = "";
			
			for (int i = 0; i < arr.length; i++) {
				
				x += "x";
				
				o += "o";
				
			}
			
			for (int j = 0; j < arr[0].length; j++) {
				
				String checking = "";
				
				for (int i = 0; i < arr.length; i++) {
					
					checking += arr[i][j];
					
				}
				
				if (checking.equals(x)) {
					
					str += "All x's in column " + (j + 1) + ".\n";
				} else if (checking.equals(o)) {
					
					str += "All o's in column " + (j + 1) + ".\n";
				}
			}
			
			if (str.equals("")) {
				return "There isn't any winning columns!";
			}
			
			return str;
		}

		public static String checkMajorLeft(String[][] arr) {
			
			
			String x = "";
			
			String o = "";
			
			for (int i = 0; i < arr.length; i++) {
				
				x += "x";
				
				o += "o";
				
			}
			
			String checking = "";
			
			for (int i = 0; i < arr.length; i++) {
				
				for (int j = i; j == i; j++) {
					
					checking += arr[i][j];
					
				}
			}
			
			if (checking.equals(x)) {
				
				return "All x's in major diagonal (left to right).";
			} else if (checking.equals(o)) {
				
				return "All o's in major diagonal (left to right).";
			} else {
				
				return "No winning diagonals (left to right)!";
			}
		}
		
		public static String checkMajorRight(String[][] arr) {
			
			
			String x = "";
			
			String o = "";
			
			for (int i = 0; i < arr.length; i++) {
				
				x += "x";
				
				o += "o";
				
			}
			

			String checking = "";
			
			int j = arr.length - 1;
			
			for (int i = 0; i < arr.length; i++) {
			
				checking += arr[i][j];

				j--;
				
			}
			

			
			if (checking.equals(x)) {
				
				return "All x's in major diagonal (right to left).";
			} else if (checking.equals(o)) {
				
				return "All o's in major diagonal (right to left).";
			} else {
				
				return "No winning diagonals (right to left)!";
			}
		}

	}

