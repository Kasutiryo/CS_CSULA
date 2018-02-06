package quiz7;

import java.util.*;

public class CourseRoll {

	protected ArrayList<Student> students = new ArrayList<Student>();
	protected int nextCIN = 1;
	protected Simulator sim = new Simulator();
	
	public void offerClass() { 
				
		double[] GPAs = sim.getLinearData(30, 2.0, 4.0);
		
		double mean = 0.0;
		
		for(int i = 0; i < GPAs.length; i++) {
			
			mean += GPAs[i];
		}
		
		mean /= 30.0;
		
		double[] GPA = sim.getGaussianData(mean, 0.10, 30, 2.0, 4.0);
				
		for (int i = 0; i < GPA.length; i++) {
			
			students.add(new Student(nextCIN, GPA[i]));
			System.out.println(students.get(i).toString());
			nextCIN++;
		}
		
		
	}
}
