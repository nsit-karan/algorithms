package com.algorithms.misc;

public class Utils {

	/*
	 * Generic swap routine to swap 2 elements in an array.
	 */
	public static <T> void swap(T A[], int i, int j) {
		T temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
