package com.algorithms.search;

public class BinarySearch {
	
	public boolean iterativeSearch(int A[]) {
		/*
		 * TODO
		 */
		return true;
		
	}
	
	public int recursiveSearch(int A[], int start_index, int end_index, int key) {
		
		if (start_index == end_index) {
			return (key == A[start_index]) ? start_index : -1;
		}
		
		int mid_index = start_index + (end_index - start_index) / 2;
		if (A[mid_index] == key) {
			return mid_index; 
		} else if (A[mid_index] > key) {
			return recursiveSearch(A, start_index, mid_index - 1, key);
		} else {
			return recursiveSearch(A, mid_index + 1, end_index, key);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int A[] = new int[] {1, 10, 20, 30, 40, 100, 500, 600, 800};
		BinarySearch b = new BinarySearch();
		System.out.println("Found at element : " + b.recursiveSearch(A, 0, A.length - 1, 500));
	}

}
