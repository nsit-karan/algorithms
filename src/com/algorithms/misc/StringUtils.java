package com.algorithms.misc;

public class StringUtils {

	public static void displayArray(int A[]) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < A.length; i++) {
			sb.append(A[i]).append(",");
		}
		System.out.println(sb.toString());
	}


}
