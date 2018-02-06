package recursion;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecursiveMethodsTest {

	@Test
	public void test_0() {
		
		RecursiveMethods test = new RecursiveMethods();
		
		assertEquals(test.returnLength("string"), "string".length());
	}
	
	@Test
	public void test_1() {
		
		RecursiveMethods test = new RecursiveMethods();
		
		assertEquals(test.returnLength(""), "".length());
	}
	
	@Test
	public void test_2() {
		
		RecursiveMethods test = new RecursiveMethods();
		
		assertEquals(test.returnLength("s"), "s".length());
	}
	
	@Test
	public void test_3() {
		
		RecursiveMethods test = new RecursiveMethods();
		
		assertNotEquals(test.returnLength("equals"), "notequals".length());
	}
	
	@Test
	public void test_4() {
		
		RecursiveMethods test = new RecursiveMethods();
		
		assertEquals(test.returnReverse("string"), "gnirts");
	}
	
	@Test
	public void test_5() {
		
		RecursiveMethods test = new RecursiveMethods();
		
		assertEquals(test.returnReverse("madamimadam"), "madamimadam");
	}
	
	@Test
	public void test_6() {
		
		RecursiveMethods test = new RecursiveMethods();
		
		assertNotEquals(test.returnReverse("equals"), "notequals");
	}
	
	@Test
	public void test_7() {
		
		RecursiveMethods test = new RecursiveMethods();
		
		assertTrue(test.isPalindrome("madam im adam"));
	}
	
	@Test
	public void test_8() {
		
		RecursiveMethods test = new RecursiveMethods();
		
		assertTrue(test.isPalindrome("kayak"));
	}
	
	@Test
	public void test_9() {
		
		RecursiveMethods test = new RecursiveMethods();
		
		assertTrue(test.isPalindrome("redivider"));
	}
	
	@Test
	public void test_10() {
		
		RecursiveMethods test = new RecursiveMethods();
		
		assertFalse(test.isPalindrome("notPalindrome"));
	}
}
