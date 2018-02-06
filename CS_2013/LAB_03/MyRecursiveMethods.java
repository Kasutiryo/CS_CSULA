package LAB_03;

public class MyRecursiveMethods {

	public MyRecursiveMethods() {
		
	}
	
	public boolean recursiveContains(char c, String s){

		if (s.charAt(0) == c)
			return true;
		else if (s.charAt(0) != c && s.length() == 1)
			return false;
		else
			return recursiveContains(c, s.substring(1));
	}
	
	public boolean recursiveAllCharactersSame(String s){

		if (s.charAt(0) != s.charAt(1))
			return false;
		else if (s.charAt(0) == s.charAt(1) && s.length() == 2) 
			return true;
		else if (s.isEmpty())
			return true;
		else 	
			return recursiveAllCharactersSame(s.substring(1));
			
	}
	
	public int recursiveCount(char c, String s){

		int count = 0;
		
		if (s.charAt(0) != c && s.length() == 1)
			return 0;
		else if (s.charAt(0) == c && s.length() == 1)
			return 1;
		else if (s.charAt(0) == c)
			return 1 + recursiveCount(c, s.substring(1));
		else
			return recursiveCount(c, s.substring(1));
		
		

	}
	
	public static void main(String[] args) {
		
		
		MyRecursiveMethods test = new MyRecursiveMethods();
		
		System.out.println(test.recursiveContains('s', "war"));
		
		System.out.println(test.recursiveAllCharactersSame("fssss"));
		
		System.out.println(test.recursiveCount('s', "eqwtqweq"));
		
		System.out.println(harmonicSum(3));
		
		System.out.println(powerN(2, 4));
		
		String str = "1234";
		
		String newStr = str.substring(0, str.length() - 1);
		
		//System.out.println(str);
		//System.out.println(newStr);
		
		reverseDisplay(1234567);
		
		reverseDisplay("THE");
	}
	
	public static double harmonicSum(int n) {
		if(n == 1) 
			return 1.0;
		else 
			return 1.0/n + harmonicSum(n - 1);
	}
	
	
	public static double powerN(double x, int n) {
	
		if (n == 1)
			return x;
		else 
			return x * powerN(x, n - 1);
	}
	
	public static void reverseDisplay(int value) {
		
		String str = value + "";
		
		if (str.length() == 1)
			System.out.println(str);
		else {
			System.out.print(str.charAt(str.length() - 1)); 
			reverseDisplay(Integer.parseInt(str.substring(0, str.length() - 1)));
		}
	}
	
	public static void reverseDisplay(String value) {
		
		if (value.length() == 1) 
			System.out.println(value);
		else {
			System.out.print(value.charAt(value.length() - 1));
			reverseDisplay(value.substring(0, value.length() - 1));
		}
	}
}
