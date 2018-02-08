package LAB_03;

public class maxSub {

    public static void main(String[] args) {
        Integer[] arr = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        maxSub test = new maxSub();
        test.findMax(arr); 
    }

    public void findMax(Integer[] arr) {
        int leftSum = 0;
        int rightSum = 0;
        int sum = 0;
        for (int i = 0; i < arr.length/2; i++) {
            sum += arr[i];
            if (sum > leftSum) 
                leftSum = sum;
        }
        sum = 0;
        for (int i = arr.length/2 + 1; i < arr.length; i++) {
            sum += arr[i];
            if (sum > rightSum)
                rightSum = sum;
        }
        System.out.println("The max right sum is: " + rightSum);
        System.out.println("The max left sum is: " + leftSum);
        System.out.println("The max sum is: " + (leftSum + rightSum));

    }
}