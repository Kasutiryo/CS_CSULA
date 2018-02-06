package haunted;

public class Driver {
	
	public static void main(String[] args) {
		
		Street test = new Street("Pico Blvd");
		
		test.addHouse(123.1, true, "Beautiful Garden");
		test.addHouse(32.2, true, "3 Story House");
		test.addHouse(7234.3, false, "2 Pools");
		test.addHouse(5493.8, false, "Metal Fences Everywhere");
		test.addHouse(876.1, true, "Large Backyard");
		
		test.addAsylum(666.6, true, "Home for genocide criminals");
		
		test.stroll();
	}

}
