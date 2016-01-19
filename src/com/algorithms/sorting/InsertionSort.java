package com.algorithms.sorting;

import com.algorithms.misc.StringUtils;

public class InsertionSort {
	
	public void sort(int A[]) {
		
		for (int j = 2; j < A.length; j++) {
			int key = A[j];
			
			/*
			 * Insert A[j] into correct position in A[0] to A[j - 1]
			 * This assumes that 0 to j-1 is already sorted
			 */
			int i = j - 1;
			while (i > 0 && A[i] > key) {
				swap(A, i + 1, i);
				i = i - 1;
			}
			
		}
		StringUtils.displayArray(A);
		
	}
	
	private void swap(int A[], int firstLoc, int secondLoc) {
		int temp = A[firstLoc];
		A[firstLoc] = A[secondLoc];
		A[secondLoc] = temp;
	}
	
}
