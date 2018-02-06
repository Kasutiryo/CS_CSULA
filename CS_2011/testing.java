//Implement an algorithm to determine if a string has all unique characters. 
//What if you can not use additional data structures?

public class testing {

	public static void main(String[] args) {
		
		int[] a = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		
		int[] b = {110, 122, 301, 303};
		
		
		
//		for (int i = 0; i < a.length; i++) {
//			
//			System.out.print(a[i]+ " ");
//		}
//		
//		System.out.println();
		if (findIndex(a, 2) == -1) {
			
			System.out.println("Number not found!");
			
		} else {
		System.out.println(findIndex(a, 2));
		}
//		
//		for (int i = 0; i < a.length; i++) {
//		
//				System.out.print(a[i]+ " ");
//		}
	}

	public static boolean isUnique(String str) {

		String raw = str.toLowerCase();

		for (int i = 0, counter = 0; i < raw.length() - 1; i++) {

			for (int j = i + 1; j < raw.length(); j++) {

				if (raw.charAt(i) == raw.charAt(j)) {

					counter++;
				}

			}
			if (counter > 0) {

				return false;
			}
		}

		return true;

	}

	public static String getReverse(String str) {

		String reverse = "";

		for (int i = str.length() - 1; i > -1; i--) {

			reverse += "" + str.charAt(i);

		}

		return reverse;

	}

	public static String removeDuplicate(String str) {

		String uniqueWord = "";

		for (int i = 0; i < str.length(); i++) {
			
			if (!uniqueWord.contains(str.charAt(i) + "")) {
				
				uniqueWord += str.charAt(i);
				
			}
			
		}
		
		return uniqueWord;
		
	}

	public static boolean isAnagram(String x, String y) {

		if (x.length() != y.length()) {

			return false;
		}
		
		String str = y;

		for (int i = 0; i < x.length(); i++) {

			int index = str.indexOf(x.charAt(i));

			if (index != -1) {
				
				str = str.substring(0, index) + str.substring(index + 1, str.length());
			} else {
				return false;
			}

		}
		return true;
	}

	public static char[] replaceSpaces(String str) {

		int counter = 0;

		for (int i = 0; i < str.length(); i++) {
		
			if(str.charAt(i) == ' ') {

				counter++;
			}
		}
		
		counter *= 3;

		char[] newWord = new char[str.length() + counter];
		
		int index = 0;
		
		for (int i = 0; i < str.length(); i++) {

			if (Character.isLetter(str.charAt(i))) {

				newWord[index] = str.charAt(i);	
				index++;
			} else if (!Character.isLetter(str.charAt(i))) {

				newWord[index] = '%';
				newWord[index + 1] = '2';
				newWord[index + 2] = '0';
				index += 3;
			}
		}
		
		return newWord;

	}

	public static int[][] zeroRowColumn(int[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			
			boolean hasZero = false;
		
			for (int j = 0; j < matrix[i].length; j++) {
			
				if (matrix[i][j] == 0) {
					hasZero = true;
					break;			
				}	
			}
			
			if (hasZero) {

				for (int j = 0; j < matrix[i].length; j++) {

					matrix[i][j] = 0;
					
				}
			} 
		}
		
		return matrix;
	}

	public static int[] mergeSort(int[] a, int[] b) {

		for (int i = 0; i < b.length; i++) {

			for (int j = i; j < a.length; j++) {
				
				if (b[i] < a[j]) {
					int temp = a[j];
					a[j] = b[i];
					b[i] = temp;
				} else if (b[i] > a[j] && a[j] == 0) {

					a[j] = b[i];
					break;
				}
			}
		} 

		return a;

	}

	public static int findIndex(int[] arr, int finding) {
	
	//rotation(arr);

	for (int i = 0; i < arr.length; i++) {
		
		if(arr[i] == finding) {
			
			return i;
		}
	}
	
	return -1;
	}
}
