/*package lab7;

import static org.junit.Assert.*;

import org.junit.Test;

public class MySetTester {

	@Test
	public void testMySetCreated() {
		int[] tested = { 1, 2, 3, 4, 5 };
		MySet a = new MySet(tested);
		assertNotNull(a);
	}

	@Test
	public void testString() {
		int[] tested = { 1, 4, 5, 8, 6 };
		MySet a = new MySet(tested);
		assertNotNull(a.toString());
	}

	@Test
	public void testEquals() {
		int[] tested1 = { 1, 2, 3, 4 };
		int[] tested2 = { 1, 2, 3, 4 };
		MySet a = new MySet(tested1);
		MySet b = new MySet(tested2);
		assertTrue(a.equals(b));
	}

	@Test
	public void testNotEquals() {
		int[] tested1 = { 1, 2, 3, 4 };
		int[] tested2 = { 5, 6, 7, 8 };
		MySet a = new MySet(tested1);
		MySet b = new MySet(tested2);
		assertFalse(a.equals(b));
	}

	@Test
	public void testAdd1() {
		int[] tested1 = { 1, 2, 3, 4 };
		int[] tested2 = { 5, 6, 7, 8 };
		int[] tested3 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		MySet a = new MySet(tested1);
		MySet b = new MySet(tested2);
		assertEquals(new MySet(tested3), a.add(b));
	}

	@Test
	public void testAdd2() {
		int[] tested1 = { 1, 2, 3, 4, 5, 6 };
		int[] tested2 = { 7, 8, 9 };
		int[] tested3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		MySet a = new MySet(tested1);
		MySet b = new MySet(tested2);
		assertEquals(new MySet(tested3), a.add(b));
	}

	@Test
	public void testAdd3() {
		int[] tested1 = { 1, 2, 3, 4 };
		int[] tested2 = { 5, 6, 7, 8, 9, 10 };
		int[] tested3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		MySet a = new MySet(tested1);
		MySet b = new MySet(tested2);
		assertEquals(new MySet(tested3), a.add(b));
	}

	@Test
	public void testSubtract1() {
		int[] tested1 = { 1, 2, 3, 4 };
		int[] tested2 = { 5, 6, 7, 8 };
		int[] tested3 = { 5, 6, 7, 8 };
		MySet a = new MySet(tested1);
		MySet b = new MySet(tested2);
		assertEquals(new MySet(tested3), a.subtract(b));
	}

	@Test
	public void testSubtract2() {
		int[] tested1 = { 1, 2, 3, 4, 5, 6 };
		int[] tested2 = { 7, 8, 9 };
		int[] tested3 = { 7, 8, 9 };
		MySet a = new MySet(tested1);
		MySet b = new MySet(tested2);
		assertEquals(new MySet(tested3), a.subtract(b));
	}

	@Test
	public void testSubtract3() {
		int[] tested1 = { 1, 2, 3, 4 };
		int[] tested2 = { 5, 6, 7, 8, 9, 10 };
		int[] tested3 = { 5, 6, 7, 8, 9, 10 };
		MySet a = new MySet(tested1);
		MySet b = new MySet(tested2);
		assertEquals(new MySet(tested3), a.subtract(b));
	}

	@Test
	public void testMultiply1() {
		int[] tested1 = { 1, 2, 3, 4 };
		int[] tested2 = { 5, 6, 7, 8 };
		int[] tested3 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		MySet a = new MySet(tested1);
		MySet b = new MySet(tested2);
		assertEquals(new MySet(tested3), a.multiply(b));
	}

	@Test
	public void testMultiply2() {
		int[] tested1 = { 1, 2, 3, 4 };
		int[] tested2 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] tested3 = { 5, 6, 7, 8 };
		MySet a = new MySet(tested1);
		MySet b = new MySet(tested2);
		assertEquals(new MySet(tested3), a.multiply(b));
	}

	@Test
	public void testMultipy3() {
		int[] tested1 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] tested2 = { 5, 6, 7, 8 };
		int[] tested3 = { 1, 2, 3, 4 };
		MySet a = new MySet(tested1);
		MySet b = new MySet(tested2);
		assertEquals(new MySet(tested3), a.multiply(b));
	}

	@Test
	public void testDivide1() {
		int[] tested1 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] tested2 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] tested3 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		MySet a = new MySet(tested1);
		MySet b = new MySet(tested2);
		assertEquals(new MySet(tested3), a.divide(b));
	}

	@Test
	public void testDivide2() {
		int[] tested1 = { 5, 6, 7, 8 };
		int[] tested2 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] tested3 = { 5, 6, 7, 8 };
		MySet a = new MySet(tested1);
		MySet b = new MySet(tested2);
		assertEquals(new MySet(tested3), a.divide(b));
	}

	@Test
	public void testDivide3() {
		int[] tested1 = { 1, 2, 3, 4 };
		int[] tested2 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] tested3 = { 1, 2, 3, 4 };
		MySet a = new MySet(tested1);
		MySet b = new MySet(tested2);
		assertEquals(new MySet(tested3), a.divide(b));
	}

}
*/