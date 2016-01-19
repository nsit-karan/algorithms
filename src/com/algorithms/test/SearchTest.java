package com.algorithms.test;

import com.algorithms.search.LinearSearch;

public class SearchTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int A[] = new int[] {200, 300, 3, 4, 10, 20, 100, 70, 60};
		int min_pos = LinearSearch.findMin(A, 4);
		System.out.printf("min localtion : %d, min element : %d", min_pos, A[min_pos]);
	}

}
