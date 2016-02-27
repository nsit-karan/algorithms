package com.algorithms.sorting;

import com.algorithms.misc.StringUtils;
import com.algorithms.misc.Utils;

public class QuickSort {
	
	public void sortRoutine(int A[], int p, int r) {
		if (p < r) {
			int q = partition(A, p, r);
			sortRoutine(A, p, q - 1);
			sortRoutine(A, q + 1, r);
		}
	}
	
	public int partition(int A[], int p, int r) {
		int x = A[r];
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (A[j] <= x) {
				i = i + 1;
				Utils.swap(A, i, j);
			}
			
			/*
			 * ELse part:
			 * - in case the value is greater, then only j is incremented.
			 *   i+1 to j-1 continues to hold all values which are greater than the pivot
			 *   element which is x
			 */
		}
		
		/*
		 * Finally, swap the pivot element(which continues to be at index r throughout the algo run)
		 * with element at i+1.
		 * 
		 * Element at i+1 was an integer greater than x.
		 * Since x is swapped with A[i+1], the element continues to be greater than x
		 * 
		 * Finally, at the end, all indices less than i+1 have value less than x
		 * and all indices greater than i have value greater than x
		 */
		Utils.swap(A, i + 1, r);
		return i + 1;
	}

	public static void main(String[] args) {
		
		int A[] = new int[]{10, 100, 80, 200, 50, 40, 55};
		
		StringUtils.displayArray(A, "Original array");
		
		QuickSort qs = new QuickSort();
		qs.partition(A, 0, A.length - 1);
		
		StringUtils.displayArray(A, "Array after parition is called");
		
		A = new int[] {10, 100, 80, 200, 50, 40, 55};
		qs.sortRoutine(A, 0, A.length - 1);
		StringUtils.displayArray(A, "Array after quick sort is called");
	}

}
