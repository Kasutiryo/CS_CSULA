package lab7;

public class Driver {

	public static void main(String[] args) {
		
	 
		MyFraction test1 = new MyFraction(4, 18, '+');
		
		MyFraction test2 = new MyFraction(10, 100, '-');
		
		MyFraction test3 = new MyFraction(4, 18, '-');
		
		MyFraction test4 = test1.add(test3);
		
		MyFraction test5 = test2.divide(test3);
		
		MyFraction test6 = test3.multiply(test1);
		
		MyFraction test7 = test2.subtract(test1);
		
		System.out.println(test1.equals(test3));
		
		System.out.println(test1.equals(test2));
		
		System.out.println(test1.toString());
		System.out.println(test2.toString());
		System.out.println(test3.toString());
		System.out.println(test4.toString());
		System.out.println(test5.toString());
		System.out.println(test6.toString());
		System.out.println(test7.toString());
		
		
	}
}
