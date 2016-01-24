package com.algorithms.misc;

public class StringUtils {

	public static void displayArray(int A[], String logger) {
		StringBuilder sb = new StringBuilder(logger).append(" : ");
		for (int i = 0; i < A.length; i++) {
			sb.append(A[i]).append(",");
		}
		System.out.println(sb.toString());
	}


}
