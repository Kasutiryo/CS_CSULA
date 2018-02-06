package LAB_00;

import java.util.ArrayList;

public class generics {

	public static void main(String[] args) {
		
	}

	public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
		
		for (int i = 0; i < list.length; i++) {
			
			if (list[i].equals(key)) {
				
				return 1;
			}
		}
		
		return 0;
	}
	
	public static <E extends Comparable<E>> int binarySearch(E[] list, E key) {
		
		int i = 0;
		int j = list.length - 1;
		
		while (i <= j) {
			
			int k = (j - i) / 2 + i;
			
			if (list[k].compareTo(key) == 0) {
				return k;
			} else if (list[k].compareTo(key) == -1) {
				
				i = k + 1;
			} else {
				
				j = k - 1;
			}
		}
		return -1;
	}
	
	public static<E extends Comparable<E>> void bubbleSort(E[] list) {
		
		E temp;
		
		for (int i = 0; i < list.length; i++) {
			
			for (int j = i + 1; j < list.length - i; j++) {
				
				if (list[j - 1].compareTo(list[j]) == 1) {

					temp = list[j - 1];
					list[j - 1] = list[j];
					list[j] = temp;
					
				}
			}
		}
	}
	
	public static<E> ArrayList<E> removeDuplicates(E[] list) {
		
		ArrayList<E> toReturn = new ArrayList<>();
		
		for (int i = 0; i < list.length; i++) {
				
			if (!toReturn.contains(list[i])) {
					
				toReturn.add(list[i]);
			}
		}
		
		return toReturn;
	}
	
	public static <E extends Comparable<E>> E max(E[][] list) {
		
		E max = list[0][0];
		
		for (int i = 0; i < list.length; i++) {
			
			for (int j = 0; j < list[i].length; j++) {
				
				if(list[i][j].compareTo(max) == -1) {
					
					max = list[i][j];
				}
			}
		}
		
		return max;
	}
	
}