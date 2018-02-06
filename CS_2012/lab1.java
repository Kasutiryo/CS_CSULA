import java.util.Scanner;

public class lab1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] num = createArr();

		printArr(num);

		printSqrt(num);

		printArr(num);

		replaceFive(num);

		printArr(num);

		double[] recip = reciprocal(num);

		printArr(recip);

		printArr(num);
	}

	public static double[] createArr() {

		Scanner input = new Scanner(System.in);

		double[] arr = new double[10];

		for (int i = 0; i < 10; i++) {

			arr[i] = input.nextDouble();
		}

		input.close();

		return arr;
	}

	public static void printSqrt(double[] arr) {

		for (double x : arr) {

			System.out.println(Math.sqrt(x));

		}
	}

	public static void replaceFive(double[] arr) {

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > 500.0) {

				arr[i] = 500.0;
			}
		}
	}

	public static void printArr(double[] arr) {

		for (double x : arr) {

			System.out.println(x);

		}
	}

	public static double[] reciprocal(double[] arr) {

		double[] newArr = new double[arr.length];

		for (int i = 0; i < arr.length; i++) {

			newArr[i] = 1 / arr[i];
		}

		return newArr;

	}

}
