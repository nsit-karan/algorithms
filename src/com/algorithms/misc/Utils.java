package com.algorithms.misc;

public class Utils {

	/*
	 * TODO : Convert to use generics
	 */
	public static void swap(int A[], int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

}
