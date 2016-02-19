package com.algorithms.sorting;

import com.algorithms.misc.StringUtils;
import com.algorithms.misc.Utils;

public class BubbleSort {

	public void sort(Integer A[]) {
		
		for (Integer i = 0; i < A.length; i++) {
			for (Integer j = A.length - 1; j > i; j--) {
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
		
		Integer A[] = new Integer[] {1, 100, 50, 40, 200, 800, 500, 400};
		BubbleSort b = new BubbleSort();
		b.sort(A);
		StringUtils.displayArray(A, "bubble soreted array");
		
	}

}
