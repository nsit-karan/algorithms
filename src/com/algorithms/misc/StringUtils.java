package com.algorithms.misc;

import java.util.List;

public class StringUtils {

	public static void displayArray(int A[], String logger) {
		StringBuilder sb = new StringBuilder(logger).append(" : ");
		for (int i = 0; i < A.length; i++) {
			sb.append(A[i]).append(",");
		}
		System.out.println(sb.toString());
	}
	
	public static <T> void displayArray(T A[], String logger) {
		StringBuilder sb = new StringBuilder(logger).append(" : ");
		
		for (T t : A) {
			sb.append(t).append(",");
		}
		System.out.println(sb.toString() + "\n");
	}
	
	public static <T> void displayArray(List<T> A, String logger) {
		StringBuilder sb = new StringBuilder(logger).append(" : ");
		
		for (T t : A) {
			sb.append(t).append(",");
		}
		System.out.println(sb.toString() + "\n");
	}


}
