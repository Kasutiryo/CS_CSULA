package attacks;

public class MonsterAttackDriver {

	public static void main(String[] args) {
		
		
		 AttackMonitor run = new AttackMonitor();
		 
		 run.testData(0, "11/11/1990", "Godzilla", "Los Angeles", "Max Powers");
		 run.testData(1, "11/12/1991", "Turtle", "New York", "John Smith");
		 run.testData(2, "12/13/1993", "Demon", "Malibu", "Edward Rogers");
		 run.testData(3, "02/01/2017", "Pokemon", "Washington", "John Doe");
		 
		 run.monitor();
	}

}
