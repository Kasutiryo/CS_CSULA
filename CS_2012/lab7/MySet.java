package lab7;

import java.util.*;

public class MySet implements MyMath<MySet> {

	private int[] arr;

	public MySet(int[] a) {

		int newLength = a.length;

		for (int i = 0; i < a.length; i++) {

			for (int j = i + 1; j < a.length; j++) {

				if (a[i] == a[j] && a[i] != 0) {

					newLength--;

					a[j] = 0;
				}
			}
		}

		int[] temp = new int[a.length];

		for (int i = 0, j = 0; i < a.length; i++) {

			if (a[i] != 0) {

				temp[j] = a[i];

				j++;
			}
		}

		int[] toReturn = new int[newLength];

		for (int i = 0; i < toReturn.length; i++) {

			toReturn[i] = temp[i];
		}

		this.arr = toReturn;
	}

	public void printArr(MySet a) {

		for (int i = 0; i < a.arr.length; i++) {

			System.out.print(a.arr[i] + ", ");
		}

		System.out.println();
	}

	public void printArr(int[] a) {

		for (int i = 0; i < a.length; i++) {

			System.out.print(a[i] + ", ");
		}

		System.out.println();
	}

	@Override
	public boolean equals(Object o) {

		MySet test = (MySet) o;

		boolean p = false;

		int[] inp_arr = test.arr;

		int[] int_arr = this.arr;

		Arrays.sort(inp_arr);

		Arrays.sort(int_arr);

		if (test.arr.length != this.arr.length) {

			return p;

		} else if (test.arr.length > this.arr.length) {

			for (int i = 0; i < test.arr.length; i++) {

				if (inp_arr[i] != int_arr[i]) {

					return p;
				}
			}
		} else {

			for (int i = 0; i < this.arr.length; i++) {

				if (inp_arr[i] != int_arr[i]) {

					return p;
				}
			}
		}

		return true;
	}

	@Override
	public MySet add(MySet o) {

		int[] o_vals = o.arr;

		int[] int_vals = this.arr;

		Arrays.sort(o_vals);

		Arrays.sort(int_vals);

		int counter = 0;

		for (int i = 0; i < o_vals.length; i++) {

			counter++;
		}
		for (int i = 0; i < int_vals.length; i++) {

			counter++;
		}

		int[] fin = new int[counter];

		int o_vals_counter = 0;

		for (int i = 0; i < o_vals.length; i++) {

			fin[i] = o_vals[i];

			o_vals_counter++;
		}

		for (int y = o_vals_counter, z = 0; y < fin.length; y++, z++) {

			fin[y] = int_vals[z];
		}

		Arrays.sort(fin);

		MySet p = new MySet(fin);

		return p;
	}

	public String toString() {

		String s = "This set consists of ";

		for (int i = 0; i < arr.length; i++) {

			s += arr[i];

			s += ", ";
		}

		return s;
	}

	@Override
	public MySet subtract(MySet o) {

		int[] o_vals = o.arr;

		int[] int_vals = this.arr;

		Arrays.sort(o_vals);

		Arrays.sort(int_vals);

		int o_vals_counter = 0;

		int int_vals_counter = 0;

		for (int i = 0; i < o_vals.length; i++) {

			o_vals_counter++;
		}

		for (int i = 0; i < int_vals.length; i++) {

			int_vals_counter++;

		}

		int[] fin = new int[o_vals_counter + int_vals_counter];

		int diff_counter = 0;

		boolean switch_test = false;

		for (int i = 0; i < o_vals.length; i++) {

			int test = o_vals[i];

			for (int p = 0; p < int_vals.length; p++) {

				if (test == int_vals[p]) {

					switch_test = true;
				}
			}

			if (switch_test == false) {

				fin[diff_counter] = test;

				diff_counter++;
			}
			switch_test = false;
		}

		int[] fin2 = new int[diff_counter];

		for (int l = 0; l < diff_counter; l++) {

			fin2[l] = fin[l];
		}
		Arrays.sort(fin2);

		MySet w = new MySet(fin2);

		return w;
	}

	@Override
	public MySet multiply(MySet o) {

		MySet a = this.subtract(o);

		MySet b = o.subtract(this);

		int[] fin = new int[a.arr.length + b.arr.length];

		int arr_counter = 0;

		for (int i = 0; i < a.arr.length; i++) {

			fin[i] = a.arr[i];

			arr_counter++;
		}

		for (int p = 0; p < b.arr.length; p++) {

			fin[arr_counter] = b.arr[p];

			arr_counter++;
		}
		Arrays.sort(fin);

		MySet w = new MySet(fin);

		return w;
	}

	@Override
	public MySet divide(MySet o) {

		int[] o_vals = o.arr;

		int[] int_vals = this.arr;

		Arrays.sort(o_vals);

		Arrays.sort(int_vals);

		int[] fin = new int[o_vals.length + int_vals.length];

		int same_counter = 0;

		for (int i = 0; i < o_vals.length; i++) {

			int test = o_vals[i];

			for (int p = 0; p < int_vals.length; p++) {

				if (test == int_vals[p]) {

					fin[same_counter] = o_vals[i];

					same_counter++;
				}
			}
		}
		int[] fin2 = new int[same_counter];

		for (int l = 0; l < same_counter; l++) {

			fin2[l] = fin[l];
		}
		MySet w = new MySet(fin2);

		return w;
	}
}
