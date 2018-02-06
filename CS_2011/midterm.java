	import java.util.Scanner;
public class midterm {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Name 1: ");
		String name1 = input.nextLine();
		System.out.print("Enter Name 2: ");
		String name2 = input.nextLine();
		System.out.print("Enter name 3: ");
		String name3 = input.nextLine();
		String fullName = "";
		String fullName_2 = "";
		String fullName_3 = "";
		if (name1.indexOf(',') != -1) {
			//System.out.println(name1);
			fullName = name1;
		}
		else {
			String lastName = name1.substring(name1.lastIndexOf(' ') + 1, name1.length()) + ", ";
			String firstName = name1.substring(0,name1.indexOf(' '));
			String middleName = name1.substring(name1.indexOf(' ') + 1, name1.lastIndexOf(' ') + 1 );
			fullName = lastName + firstName + " " + middleName;
		}
		if (name2.indexOf(',') != -1) {
			//System.out.println(name2);
			fullName_2 = name2;
		}
		else {
			String lastName_2 =  name2.substring(name2.lastIndexOf(' ') + 1, name2.length()) + ", ";
			String firstName_2 = name2.substring(0,name2.indexOf(' '));
			String middleName_2 = name2.substring(name2.indexOf(' ') + 1, name2.lastIndexOf(' ') + 1 );
			fullName_2 = lastName_2 + firstName_2 + " " + middleName_2;
		}
		if (name3.indexOf(',') != -1) {
			//System.out.println(name3);
			fullName_3 = name3;
		}
		else {
			String lastName_3 =  name3.substring(name3.lastIndexOf(' ') + 1, name3.length()) + ", ";
			String firstName_3 = name3.substring(0,name3.indexOf(' '));
			String middleName_3 = name3.substring(name3.indexOf(' ') + 1, name3.lastIndexOf(' ') + 1 );
			fullName_3 = lastName_3 + firstName_3 + " " + middleName_3;
		}
		System.out.println("\nSorted Names:");
		//if name1 is the the first one
		if ((fullName.toLowerCase().compareTo(fullName_2.toLowerCase()) < 0) && (fullName.toLowerCase().compareTo(fullName_3.toLowerCase()) < 0)) {
			if (fullName_2.toLowerCase().compareTo(fullName_3.toLowerCase()) < 0) {
				System.out.println("\t" + fullName + "\n\t" + fullName_2 + "\n\t" + fullName_3);
			}
			else {
				System.out.println("\t" + fullName + "\n\t" + fullName_3 + "\n\t" + fullName_2);
			}
		}
		//if name2 is the first one
		else if((fullName_2.toLowerCase().compareTo(fullName.toLowerCase()) < 0) && (fullName_2.toLowerCase().compareTo(fullName_3.toLowerCase()) < 0)) {
			if(fullName.toLowerCase().compareTo(fullName_3.toLowerCase()) < 0) {
				System.out.println("\t" + fullName_2 + "\n\t" + fullName + "\n\t" + fullName_3);
			}
			else {
				System.out.println("\t" + fullName_2 + "\n\t" + fullName_3 + "\n\t" + fullName);
			}
		}
		//if name3 is the first one
		else if((fullName_3.toLowerCase().compareTo(fullName.toLowerCase()) < 0) && (fullName_3.toLowerCase().compareTo(fullName_2.toLowerCase()) < 0)) {
			if(fullName.toLowerCase().compareTo(fullName_2.toLowerCase()) < 0) {
				System.out.println("\t" + fullName_3 + "\n\t" + fullName + "\n\t" + fullName_2);
			}
			else {
				System.out.println("\t" + fullName_3 + "\n\t" + fullName_2 + "\n\t" + fullName);
			}
		}
	}
}