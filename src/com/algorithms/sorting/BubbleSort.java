package com.algorithms.sorting;

import com.algorithms.misc.StringUtils;
import com.algorithms.misc.Utils;

public class BubbleSort {

	public void sort(int A[]) {
		
		for (int i = 0; i < A.length; i++) {
			for (int j = A.length - 1; j > i; j--) {
				if (A[j] < A[j - 1]) {
					Utils.swap(A, j, j - 1);
				}
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int A[] = new int[] {1, 100, 50, 40, 200, 800, 500, 400};
		BubbleSort b = new BubbleSort();
		b.sort(A);
		StringUtils.displayArray(A, "bubble soreted array");
		
	}

}
