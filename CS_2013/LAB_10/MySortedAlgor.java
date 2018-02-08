package LAB_10;

import java.util.ArrayList;

public class MySortedAlgor<E extends Comparable<E>> {

	public E[] selectionSort(E[] list, int limit) {

		if (limit == 1) return list;	
		E max = list[0];
		int indexOfMax = 0;
		for (int i = 0; i < limit; i++) {
			if (max.compareTo(list[i]) < 0) { 
				max = list[i];
				indexOfMax = i;
			}
		}	
		list[indexOfMax] = list[limit - 1];
		list[limit - 1] = max; 
		return selectionSort(list, limit - 1);
	}

	public void insertionSort(E[] list) {

		for (int i = 1; i < list.length; i++) {
			E key = list[i];
			int j = i - 1;
			while (j >= 0 && list[j].compareTo(key) > 0) {
				list[j + 1] = list[j];
				j--; 
			} 	
			list[j + 1] = key;
		}
	}


	public void mergeSort(int[] list) {
		//if(list.size() > 1) {
		int length = list.length/2;
		int[] list1 = new int[length];
		int[] list2 = new int[list.length - length];
		System.arraycopy(list, 0, list1, 0, length);
		System.arraycopy(list, length, list2, 0, list.length - length);
		mergeSort(list1);
		mergeSort(list2);
		for (int item: list1) {
			System.out.print(item + " ");
		}
		System.out.println();
		for (int item: list2) {
			System.out.print(item + " ");
		}
		System.out.println();

		//}
	}

	public static void main(String[] args) {

		Integer[] list = {28,72,98,13,87,66,52,51,36};

		ArrayList<Integer> aList = new ArrayList<>();

		for (int i = 0; i < list.length; i++) {
			aList.add(list[i]);
		}

		MySortedAlgor<Integer> algo = new MySortedAlgor<>();

		algo.insertionSort(list);
		//algo.selectionSort(list, list.length);
		//algo.mergeSort(list); 

		for (Integer item: list) {
			System.out.print(item + ", "); 
		}
	}
}
