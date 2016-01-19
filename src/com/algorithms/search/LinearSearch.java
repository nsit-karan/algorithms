package com.algorithms.search;

public class LinearSearch {
	
	/**
	 * Returns the index of the max element
	 * 
	 * @param A
	 * @return index
	 */
	public static int findMax(int A[], int start_index) {
		int max_loc = start_index;
		int max = A[start_index];
		for (int i = start_index; i < A.length; i++) {
			if (A[i] > max) {
				max = A[i];
				max_loc = i;
			}
		}
		
		return max_loc;
	}
	
	/**
	 * Returns the index of the min elements
	 * 
	 * @param A
	 * @return index
	 */
	public static int findMin(int A[], int start_index) {
		int min_loc = start_index;
		int min = A[start_index];
		for (int i = start_index; i < A.length; i++) {
			if (A[i] < min) {
				min = A[i];
				min_loc = i;
			}
		}
		
		return min_loc;
	}

}
