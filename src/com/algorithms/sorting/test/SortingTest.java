package com.algorithms.sorting.test;

import com.algorithms.sorting.InsertionSort;

public class SortingTest {

	public static void main(String[] args) {
		
		try {
			int A[] = new int[] {1, 10, 4, 5, 20, 30, 2, 3};
			InsertionSort sort = new InsertionSort();
			sort.sort(A);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
