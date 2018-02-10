package LAB_03;

public class maxSub {

    public static void main(String[] args) {
    	
    	Integer[] data = {100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97};
        maxSub test = new maxSub();
        test.findMax(data); 
        test.findMaxRecursive(data);
    }

    /**
     * Helper Method. Takes in the raw data and calculates the differences at a running time
     * of O(n). Please note that the original data must be contain the starting price as the first
     * element of the data[] array.
     * @param data Raw data you'd like to use to calculate the Max Crossing Sub-Array.
     */
    public void findMax(Integer[] data) {
    	
    	Integer[] differences= new Integer[data.length - 1];
    	for (int i = 1; i < data.length; i++) {
    		differences[i - 1] = data[i] - data[i - 1];
    	}
    	
    	Integer[] results = findMax(differences, 0, differences.length/2, differences.length);
    	for (Integer arr: results) {
    		System.out.println(arr);
    	}
    }
    
    /**
     * Calculates the Max Crossing Sub-Array using an array of differences at an additional running time
     * of O(n), for a total of O(n^2).
     * @param diff Data calculated by helper method.
     * @param low Data calculated by helper method.
     * @param mid Data calculated by helper method.
     * @param high Data calculated by helper method.
     * @return Returns a Integer[] array of size three, in which contains the Left Max Array, Right Max Array, and the Cross Sum
     * respectively. 
     */
    public Integer[] findMax(Integer[] diff, int low, int mid, int high) {
    	
        int leftSum = 0, rightSum = 0, sum = 0, maxLeft = 0, maxRight = 0;
        for (int i = mid; i > low; i--) {
            sum += diff[i];
            if (sum > leftSum) { 
                leftSum = sum;
            	maxLeft = i;
            }
        }
        sum = 0;
        for (int i = mid + 1; i < high; i++) {
            sum += diff[i];
            if (sum > rightSum) {
                rightSum = sum;
            	maxRight = i;
            }
        }
        maxLeft++;
        maxRight++;
        return new Integer[] {maxLeft, maxRight, (leftSum + rightSum)};
    }
    
    /**
     * Helper Method. Takes in the raw data and calculates the differences at a running time
     * of O(n). Please note that the original data must be contain the starting price as the first
     * element of the data[] array.
     * @param data Raw data you'd like to use to calculate the Max Crossing Sub-Array.
     */
    public void findMaxRecursive(Integer[] data) {
    	
    	Integer[] differences= new Integer[data.length - 1];
    	for (int i = 1; i < data.length; i++) {
    		differences[i - 1] = data[i] - data[i - 1];
    	}
    	
    	Integer[] results = findMaxRecursive(differences, differences.length - 1, 0);
    	for (Integer arr: results) {
    		System.out.println(arr);
    	}
    }
    
    /**
     * Recursively finds the Max Crossing Sub-Array at a running time of O(Log n) for a total
     * of O(n Log n).
     * @param arr Provided through helper method.
     * @param high Provided through helper method.
     * @param low Provided through helper method.
     * @return
     */
    public Integer[] findMaxRecursive(Integer[] arr, int high, int low) {
    	
    	if (high == low) {
    		return new Integer[] {low, high, arr[low]};
    	} else {
    		int mid = (low + high)/2;
    		Integer[] left = findMaxRecursive(arr, low, mid);
    		int leftLow = left[0], leftHigh = left[1], leftSum = left[2]; 
  			Integer[] right = findMaxRecursive(arr, mid + 1, high);
  			int rightLow = right[0], rightHigh = right[1], rightSum = right[2]; 
  			Integer[] cross = findMax(arr, low, mid, high);
    		int crossLow = cross[0], crossHigh = cross[1], crossSum = cross[2];
    		if ((leftSum >= rightSum) && (leftSum >= crossSum)) 
    			return new Integer[] {leftLow, leftHigh, leftSum};
    		else if ((rightSum >= leftSum) && (rightSum >= crossSum))
    			return new Integer[] {rightLow, rightHigh, rightSum};
    		else
    			return new Integer[] {crossLow, crossHigh, crossSum};
    	}					
    }
}