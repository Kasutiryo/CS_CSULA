package Homework_10;

import javax.swing.JOptionPane;

public class HW10P04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int[] arr = {3, 1, 2, 4, 2, 2, 2, 4, 4, 2, 3, 3, 4, 3, 1, 1, 1, 1, 1, 1, 4, 4, 4, 4, 3, 3, 2, 1, 4, 3};
		algorithum(generateArr(getNumberOfValues()));
		
		//algorithum(arr);
	
	}

	public static int getNumberOfValues() {
		
		return Integer.parseInt(JOptionPane.showInputDialog(null, "How many random values?"));
		
	}
	
	public static int[] generateArr(int nums) {
		
		java.util.Random r = new java.util.Random();
		
		int[] randomArr = new int[nums];
		
		for (int i = 0; i < randomArr.length; i++) {
			
			randomArr[i] = r.nextInt(4);
			
		}
		
		return randomArr;
	}
	
	public static void algorithum(int[] arr) {
		
		String str = "";
		
		boolean hasParenthesis = false;
		
		
		for (int i = 1; i < arr.length; i++) {
			 
			if (arr[i] == arr[i - 1] && !hasParenthesis) {
					
				str += "( " + arr[i - 1] + " ";
				
				hasParenthesis = true;
				
			} else if (arr[i] != arr[i - 1] && hasParenthesis) {
					
				str += arr[i - 1] + " ) ";
				
				hasParenthesis = false;
			
			}	else {
				
				str += arr[i - 1] + " ";
				
			}
		}
		
		if (arr[arr.length - 1] == arr[arr.length - 2]) {
			
		str += arr[arr.length - 1] + " )";
		
		} else {
			
			str += arr[arr.length - 1];
			
		}
		
		JOptionPane.showMessageDialog(null, str);
	}
}
