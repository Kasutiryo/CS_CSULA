package recursion;

public class RecursiveMethods {
	
	public int returnLength(String str) {
		int total = 0;
		if(str.length() == 1) {
			return total += 1;
		} else if(str.length() == 0) {
			
			return 0;
		}	else {

			total++;
			return total + returnLength(str.substring(1));

		}
	}

	public String returnReverse(String str) {

		String toReturn = "";
		
		if (str.length() == 1) {
			return "" + str.charAt(0);
		} 
			toReturn += str.charAt(0);
			return (returnReverse(str.substring(1)) + toReturn).toLowerCase();
		}
	
	public boolean isPalindrome(String str) {
		
		str.toLowerCase();
		
		String newStr = "";
		
		for (int i = 0; i < str.length(); i++) {
			
			if (Character.isLetter(str.charAt(i))) {
					newStr += str.charAt(i);
			}
		}
		
		if (newStr.charAt(0) != newStr.charAt(newStr.length() - 1)) {
			
			return false;
			
		} else if (newStr.length() == 1) {
			
			return true;
		}
		
		return isPalindrome(newStr.substring(1, newStr.length() - 1));

	}
}
