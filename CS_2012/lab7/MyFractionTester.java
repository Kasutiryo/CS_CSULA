package lab7;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyFractionTester {

	@Test
	public void testMyFractionCreated() {
		
		int num = 10;
		int denom = 100;
		char sign = '-';
		
		MyFraction test = new MyFraction(num, denom, sign);
		assertNotNull(test);
	}
	
	@Test
	public void testMyFractionToString() {
		
		int num = 10;
		int denom = 100;
		char sign = '-';
		
		MyFraction test = new MyFraction(num, denom, sign);
		assertNotNull(test.toString());
	}
	
	@Test
	public void testMyFractionAdd() {
		
		MyFraction test = new MyFraction(1, 10, '+');
		
		MyFraction test2 = new MyFraction(5, 10, '+');
		
		assertEquals(new MyFraction(3, 5, '+'), test.add(test2));
	}
	
	@Test
	public void testMyFractionAdd2() {
		
		MyFraction test = new MyFraction(1, 10, '-');
		
		MyFraction test2 = new MyFraction(3, 5, '-');
		
		assertEquals(new MyFraction(7, 10, '-'), test.add(test2));
	}
	
	@Test
	public void testMyFractionAdd3() {
		
		MyFraction test = new MyFraction(1, 10, '+');
		
		MyFraction test2 = new MyFraction(5, 10, '-');
		
		assertEquals(new MyFraction(2, 5, '-'), test.add(test2));
	}
	
	@Test
	public void testMyFractionAdd4() {
		
		MyFraction test = new MyFraction(1, 10, '-');
		
		MyFraction test2 = new MyFraction(5, 10, '+');
		
		assertEquals(new MyFraction(2, 5, '+'), test.add(test2));
	}
	
	@Test
	public void testMyFractionAdd5() {
		
		MyFraction test = new MyFraction(3, 5, '+');
		
		MyFraction test2 = new MyFraction(1, 10, '+');
		
		assertEquals(new MyFraction(7, 10, '+'), test.add(test2));
	}
	@Test
	public void testMyFractionNotSame() {
		
		int num = 13230;
		int denom = 100;
		char sign = '-';
		
		MyFraction test = new MyFraction(num, denom, sign);
		
		int num2 = 100;
		int denom2 = 100;
		char sign2 = '-';
		
		MyFraction test2 = new MyFraction(num2, denom2, sign2);
		
		assertFalse(test.equals(test2));
	}
	
	@Test
	public void testMyFractionSame() {
		
		int num = 3;
		int denom = 3;
		char sign = '-';
		
		MyFraction test = new MyFraction(num, denom, sign);
		
		int num2 = 100;
		int denom2 = 100;
		char sign2 = '-';
		
		MyFraction test2 = new MyFraction(num2, denom2, sign2);
		
		assertTrue(test.equals(test2));
	}
	
	@Test
	public void testMyFractionSubtract() {
		
		MyFraction test = new MyFraction(1, 10, '+');
		
		MyFraction test2 = new MyFraction(3, 5, '+');
		
		assertEquals(new MyFraction(5, 10, '-'), test.subtract(test2));
	}
	
	@Test
	public void testMyFractionSubtract2() {
		
		MyFraction test = new MyFraction(1, 10, '-');
		
		MyFraction test2 = new MyFraction(3, 5, '-');
		
		assertEquals(new MyFraction(5, 10, '+'), test.subtract(test2));
	}
	
	@Test
	public void testMyFractionSubtract3() {
		
		MyFraction test = new MyFraction(1, 10, '+');
		
		MyFraction test2 = new MyFraction(3, 5, '-');
		
		assertEquals(new MyFraction(7, 10, '+'), test.subtract(test2));
	}
	
	@Test
	public void testMyFractionSubtract4() {
		
		MyFraction test = new MyFraction(1, 10, '-');
		
		MyFraction test2 = new MyFraction(3, 5, '+');
		
		assertEquals(new MyFraction(7, 10, '-'), test.subtract(test2));
	}
	
	@Test
	public void testMyFractionSubtract5() {
		
		MyFraction test = new MyFraction(1, 10, '+');
		
		MyFraction test2 = new MyFraction(8, 10, '-');
		
		assertEquals(new MyFraction(9, 10, '+'), test.subtract(test2));
	}
	
	@Test
	public void testMyFractionDivide() {
		
		MyFraction test = new MyFraction(1, 10, '-');
		
		MyFraction test2 = new MyFraction(3, 5, '+');
		
		assertEquals(new MyFraction(1, 6, '-'), test.divide(test2));
	}
	
	@Test
	public void testMyFractionMultiply() {
		
		MyFraction test = new MyFraction(1, 10, '+');
		
		MyFraction test2 = new MyFraction(3, 5, '+');
		
		assertEquals(new MyFraction(3, 50, '+'), test.multiply(test2));
	}
}
