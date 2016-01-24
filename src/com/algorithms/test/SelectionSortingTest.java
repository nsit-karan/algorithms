package com.algorithms.test;

import com.algorithms.misc.StringUtils;
import com.algorithms.sorting.SelectionSort;

public class SelectionSortingTest {

	public static void main(String[] args) {
		
		try {
			int A[] = new int[] {1, 10, 4, 5, 20, 30, 2, 3};
			SelectionSort sort = new SelectionSort();
			sort.sort(A);
			
			StringUtils.displayArray(A, "Array after sorting");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
