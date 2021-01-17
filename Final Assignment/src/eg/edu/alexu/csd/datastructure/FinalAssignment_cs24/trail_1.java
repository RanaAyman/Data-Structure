package eg.edu.alexu.csd.datastructure.FinalAssignment_cs24;

import java.util.*;
import java.lang.*;
import java.io.*;

class trail_1 {
	public static int[] printNSE(int arr[], int n) {
		Stack Element = new Stack();
		Stack Index = new Stack();
		int[] indices = new int[n];
		Element.push(arr[0]);
		Index.push(0);

		for (int i = 1; i < n; i++) {

			if (Element.isEmpty()) {
				Element.push(arr[i]);
				Index.push(i);
				continue;
			}

			while (Element.isEmpty() == false && (int) Element.peek() > arr[i]) {
				System.out.println(Element.peek() + " --> " + arr[i]);
				indices[(int) Index.pop()] = arr[i];
				Element.pop();
			}

			Element.push(arr[i]);
			Index.push(i);
		}

		while (Element.isEmpty() == false) {
			System.out.println(Element.peek() + " --> " + "-1");
			indices[(int) Index.pop()] = -1;
			Element.pop();
		}
		return indices;
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {
		int arr[] = { 10, 9, 2, 7, 6, 1, 2 };
		int n = arr.length;
		int[] indices = printNSE(arr, n);
		System.out.println();
		print(indices);
	}
}
