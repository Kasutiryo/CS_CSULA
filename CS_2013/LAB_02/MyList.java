package LAB_02;

public class MyList<E> {

	public MyList() {
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		
		
	}
	
	public static <E extends Comparable<E>> void insertionSort(E[] list) {
			
		for (int i = 1; i < list.length; i++) {
			
			E curr = list[i];
			
			for (int j = i - 1; j > 0; j--) {
				
				if (curr.compareTo(list[j]) > 0) {
					
					list[i] = list[j];
					list[j] = curr;
				} else
					break;
			}
		}	
	}
}
