package university;

import java.util.*;
import javax.swing.*;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Student> students = new ArrayList<Student>();
		ArrayList<Course> courses = new ArrayList<Course>();
		ArrayList<FacultyMember> facultyMembers = new ArrayList<FacultyMember>();
		
		courses.add(new Course("CS-101", 1));
		courses.add(new Course("CS-122", 2));
		courses.add(new Course("CS-120", 3));
		courses.add(new Course("CS-211", 4));
		courses.add(new Course("CS-212", 4));
		
		students.add(new Student("Bob", "1543", "11TH ST", "Los Angeles", "CA", "USA", "304539201"));
		students.add(new Student("Max", "2143", "Main ST", "Pomona", "CA", "USA", "102935403"));
		students.add(new Student("Juan", "9142", "Olympic Blvd", "Lincon Heights", "CA", "USA", "71579843"));
		students.add(new Student("Jose", "6892", "Alvarado St", "Long Beach", "CA", "USA", "23465789"));
		students.add(new Student("Rose", "0091", "Pico Blvd", "Santa Monica", "CA", "USA", "62324859"));
		
		facultyMembers.add(new FacultyMember("Professor Bob", "1543", "11TH ST", "Los Angeles", "CA", "USA", "304539201"));
		facultyMembers.add(new FacultyMember("Dr. Max", "2143", "Main ST", "Pomona", "CA", "USA", "102935403"));
		facultyMembers.add(new FacultyMember("Dr. Juan", "9142", "Olympic Blvd", "Lincon Heights", "CA", "USA", "71579843"));
		facultyMembers.add(new FacultyMember("Mr. Sanchez", "6892", "Alvarado St", "Long Beach", "CA", "USA", "23465789"));
		facultyMembers.add(new FacultyMember("Professor Rose", "0091", "Pico Blvd", "Santa Monica", "CA", "USA", "62324859"));
		
		boolean loop = true;
		
		while(loop) {
			
			String[] choices = {"Students", "Faculty", "ADMIN TOOLS", "Quit"};
			
			int choice = JOptionPane.showOptionDialog(null, "Student or Faculty?", "~~~~~~~MAIN MENU~~~~~~~~", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
					choices, choices[3]);
			
			switch (choice) {
				
				case 0: 
					
					studentMenu(chooseStudent(students), courses);
					break;
				case 1:
					
					facultyMenu(chooseFaculty(facultyMembers), courses);
					break;
				case 2:
					
					ADMINMenu(students, facultyMembers, courses);
					break;
				case 3:
					
					loop = false;
		
			}
		}
	}
	
	private static void studentMenu(Student you, ArrayList<Course> list) {
		
		boolean loop = true;
		
		while(loop) {
			
			String[] choices = {"Add Class", "Drop Class", "My Schedule", "Go Back"};
			
			int choice = JOptionPane.showOptionDialog(null, "What would you like to do?", "~~~~~~~STUDENT MENU~~~~~~~~", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
					choices, choices[2]);
		
			switch (choice) {
			
			case 0: 
			
				you.addCourse(chooseCourse(list));
				break;
			case 1:
				
				you.deleteCourse(chooseFromSchedule(you.getSchedule()));
				break;
			case 2:
				
				displayCourses(you.getSchedule());
				break;
			case 3:
				
				loop = false;
	
			}
		}
	}
	
	private static void facultyMenu(FacultyMember you, ArrayList<Course> list) {
		
	boolean loop = true;
		
		while(loop) {
			
			String[] choices = {"Teach a Class", "Drop Class", "My Teaching Schedule", "Go Back"};
			
			int choice = JOptionPane.showOptionDialog(null, "What would you like to do?", "~~~~~~~FACULTY MENU~~~~~~~~", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
					choices, choices[2]);
		
			switch (choice) {
			
			case 0: 
			
				you.addCourse(chooseCourse(list));
				break;
			case 1:
				
				you.deleteCourse(chooseFromSchedule(you.getSchedule()));
				break;
			case 2:
				
				displayCourses(you.getSchedule());
				break;
			case 3:
				
				loop = false;
	
			}
		}
	}
	
	private static void ADMINMenu(ArrayList<Student> sList, ArrayList<FacultyMember> fList, ArrayList<Course> cList) {
		
		boolean loop = true;
		
		while (loop) {
		
			String[] choices = {"Add new Student", "Delete Student","Show all Students", "Add new Faculty", "Delete Faculty", "Show all Faculty", "Add Course", "Go Back"};
			
			int choice = JOptionPane.showOptionDialog(null, "ADMINISTRATOR", "~~~~~~~ADMIN MENU~~~~~~~~", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
					choices, choices[5]);
			
			switch (choice) {
			
			case 0:
				
				sList.add(new Student());
				break;
			case 1:
				
				deleteStudent(sList);
				break;
			case 2:
				
				printStudents(sList);
				break;
			case 3:
				
				fList.add(new FacultyMember());
				break;
			case 4:
				
				deleteFaculty(fList);
				break;
			case 5:
				
				printFaculty(fList);
				break;
			case 6:
				
				cList.add(new Course());
				break;
			case 7:
			
				loop = false;
			}
		}
	}
	
	private static void printStudents(ArrayList<Student> list) {
		
		String toPrint = "";
		
		for (int i = 0; i < list.size(); i++) {
			
			toPrint += list.get(i).toString() + "\n";
		}
		
		JOptionPane.showMessageDialog(null, toPrint, "Students", JOptionPane.INFORMATION_MESSAGE);
	}

	private static Student chooseStudent(ArrayList<Student> list) {
		
		String[] students = new String[list.size() + 1];
		
		for (int i = 0; i < list.size(); i++) {
			
			students[i] = list.get(i).getName();
		}
		
		students[list.size()] = "Go Back";
		
		int choice = JOptionPane.showOptionDialog(null, "Who are you?", "~~~~~~~STUDENT MENU~~~~~~~~", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
				students, students[list.size()]);
		
			return list.get(choice);
	}
	
	private static FacultyMember chooseFaculty(ArrayList<FacultyMember> list) {
		
		String[] faculty = new String[list.size() + 1];
		
		for (int i = 0; i < list.size(); i++) {
			
			faculty[i] = list.get(i).getName();
		}
		
		faculty[list.size()] = "Go Back";
		
		int choice = JOptionPane.showOptionDialog(null, "Who are you?", "~~~~~~~FACULTY MENU~~~~~~~~", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
				faculty, faculty[list.size()]);
		
			return list.get(choice);
	}
	
	private static Course chooseCourse(ArrayList<Course> list) {
		
		String[] courses = new String[list.size() + 1];
		
		for (int i = 0; i < list.size(); i++) {
			
			courses[i] = list.get(i).getIdentifier();
		}
		
		courses[list.size()] = "Go Back";
		
		int choice = JOptionPane.showOptionDialog(null, "What class?", "~~~~~~~MENU~~~~~~~~", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
				courses, courses[list.size()]);
		
			return list.get(choice);
		
	}
	
	private static Course chooseFromSchedule(ArrayList<Course> list) {
		
		String[] courses = new String[list.size() + 1];
		
		for (int i = 0; i < list.size(); i++) {
			
			courses[i] = list.get(i).getIdentifier();
		}
		
		courses[list.size()] = "Go Back";
		
		int choice = JOptionPane.showOptionDialog(null, "What class?", "~~~~~~~MENU~~~~~~~~", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
				courses, courses[list.size()]);
		
			return list.get(choice);
		
	}
	
	private static void deleteStudent(ArrayList<Student> list) {
		
		String[] students = new String[list.size() + 1];
		
		for (int i = 0; i < list.size(); i++) {
			
			students[i] = list.get(i).getName();
		}
		
		students[list.size()] = "Go Back";
		
		int choice = JOptionPane.showOptionDialog(null, "       ~~~~~~~Delete a student~~~~~~~~", "Choice", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
				students, students[list.size()]);
		
		list.remove(list.get(choice));
			
	}

	private static void printFaculty(ArrayList<FacultyMember> list) {
		
		String toPrint = "";
		
		for (int i = 0; i < list.size(); i++) {
			
			toPrint += list.get(i).toString() + "\n";
		}
		
		JOptionPane.showMessageDialog(null, toPrint, "Faculty Members", JOptionPane.INFORMATION_MESSAGE);
	
	}
	
	private static void deleteFaculty(ArrayList<FacultyMember> list) {
		
		String[] faculty = new String[list.size() + 1];
		
		for (int i = 0; i < list.size(); i++) {
			
			faculty[i] = list.get(i).getName();
		}
		
		faculty[list.size()] = "Go Back";
		
		int choice = JOptionPane.showOptionDialog(null, "       ~~~~~~~Delete a faculty~~~~~~~~", "Choice", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
				faculty, faculty[list.size()]);
		
		list.remove(list.get(choice));}
	
	private static void displayCourses(ArrayList<Course> list) {
		
		String toPrint = "";
		
		for (int i = 0; i < list.size(); i++) {
			
			toPrint += list.get(i).toString() + "\n";
		}
		 	
		JOptionPane.showMessageDialog(null, toPrint, "Courses", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
