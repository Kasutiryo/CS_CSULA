package LAB_02;

import java.util.ArrayList;

public class Sort {
	
	public static <E> void main(String[] args) {
		
		Integer[] list = new Integer[5];
		
		list[0] = 2;
		list[1] = 1; //tmp = 1
		list[2] = 0; 
		list[3] = 5;
		list[4] = 4;
		
		//insertionSort(list);
		bubbleSort(list);
		
		printList(list);
	}
	
	public static <E extends Comparable<E>> void insertionSort(E[] list) {
		
		for (int i = 1; i < list.length; i++) {
			
			E tmp = list[i];
			
			int j = i - 1;
			
			while (j >= 0 && list[j].compareTo(tmp) == 1) {								//running time = O(n^2)
				
					list[j + 1] = list[j];
					j--;
			}
			
			list[j + 1] = tmp;

				printList(list);
			
		}
	}
	
	public static <E extends Comparable<E>> void bubbleSort(E[] list) {
		
		boolean hasSwapped = true;
																						
		while (hasSwapped) {												//running time = O(n^2)
		
			hasSwapped = false;
			
			for (int i = 0; i < list.length - 1; i++) {
				
				if (list[i].compareTo(list[i + 1]) == 1) {
					
					E tmp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = tmp;
					hasSwapped = true;
				}
			}
		}
	}

	public static <E extends Comparable<E>> void printList(E[] list) {
		
		String toPrint = "";
		
		for (int i = 0; i < list.length; i++) {
		
			toPrint += list[i] + " ";
			
		}
		
		System.out.println(toPrint);
	}
}
