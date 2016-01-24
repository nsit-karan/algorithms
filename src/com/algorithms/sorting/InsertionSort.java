package com.algorithms.sorting;

import com.algorithms.misc.StringUtils;

public class InsertionSort {
	
	public void sort(int A[]) {
		
		for (int j = 1; j < A.length; j++) {
			int key = A[j];
			
			/*
			 * Insert A[j] into correct position in A[0] to A[j - 1]
			 * This assumes that 0 to j-1 is already sorted
			 */
			int i = j - 1;
			while (i >= 0 && A[i] > key) {
				swap(A, i + 1, i);
				i = i - 1;
			}
			
		}
		StringUtils.displayArray(A, "array after sorting");
		
	}

	/**
	 * recursion based insertion sort:
	 * 
	 * T(n) = T(n - 1) + O(n)
	 * 
	 * Here, O(n) is the time taken to insert A[index] at correct position
	 * in A[0..... index-1].
	 * It's O(n) since worst case, will need to iterate over the entire sub array
	 * from A[0] to A[index - 1]
	 * 
	 * Solution to the above recursion : O(n^2)
	 * 
	 * 
	 * @param A
	 * @param end_index
	 */
	public void sortRecursion(int A[], int end_index) {
		
		if (end_index == 0) {
			return;
		}
		
		sortRecursion(A, end_index - 1);
		findReplaceElement(A, end_index - 1, A[end_index]);
	}

	
	private void swap(int A[], int firstLoc, int secondLoc) {
		int temp = A[firstLoc];
		A[firstLoc] = A[secondLoc];
		A[secondLoc] = temp;
	}
	
	
	public void findReplaceElement(int A[], int end_index, int key) {
		int i = end_index;
		while (i >= 0 && A[i] > key) {
			swap(A, i + 1, i);
			i = i - 1;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			int A[] = new int[] {1, 10, 4, 5, 20, 30, 2, 3};
			InsertionSort sort = new InsertionSort();
			sort.sort(A);
			
			
			A = new int[] {100, 10};
			sort.sort(A);
			
			A = new int[] {10, 20, 40, 30, 20, 30, 2, 3};
			sort.findReplaceElement(A, 2, 30);
			StringUtils.displayArray(A, "after findReplaceElement");
			
			A = new int[] {1, 10, 4, 5, 20, 30, 2, 3};
			sort.sortRecursion(A, A.length - 1);
			StringUtils.displayArray(A, "after issuing recursion based insertion sort");

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
}
