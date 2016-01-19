package com.algorithms.sorting;

import com.algorithms.search.LinearSearch;

/*
 * algo:
 * - iterate through the array and idetify the min from i to A.length
 *   and swap i with the min_index identified in prev step
 */
public class SelectionSort {
	
	public void swap(int A[], int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	public int[] sort(int A[]) {
		for (int i = 0; i < A.length; i++) {
			int min_loc = LinearSearch.findMin(A, i);
			swap(A, min_loc, i);
		}
		return A;
	}

}
