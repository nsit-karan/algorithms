package com.algorithms.misc;

import java.util.ArrayList;

public class Utils {

	/*
	 * Generic swap routine to swap 2 elements in an array.
	 */
	public static <T> void swap(T A[], int i, int j) {
		T temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	/*
	 * readibility suffers if using array list.
	 * But, get the advantage of size changes taken care of instead
	 * if bothering about increasing/decreasing the size mysql
	 */
	public static <T> void swap(ArrayList<T> A, int i, int j) {
		T temp = A.get(i);
		A.set(i, A.get(j));
		A.set(j, temp);
	}
}
