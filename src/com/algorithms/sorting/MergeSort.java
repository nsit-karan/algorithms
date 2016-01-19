package com.algorithms.sorting;

import com.algorithms.misc.StringUtils;

public class MergeSort {

	/**
	 * In case p !< r ==> only 1 elements present, so no-op
	 * For 2 element array, mergeSort routine will do nothing and merge will
	 * finally sort the 2 in increasing order
	 * 
	 * @param A
	 * @param p
	 * @param r
	 */
	public void mergeSort(int A[], int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(A, p, q);
			mergeSort(A, q + 1, r);
			merge(A, p, q, r);
		}
	}
	
	public void merge(int A[], int p, int q, int r) {
		
		int n1 = q - p + 1;
		/*
		 * This is in fact : r - (q + 1) - 1
		 *                   where q+1 and r are the indices for start/end
		 *                   of the second sub array
		 */
		int n2 = r - q;
		
		int L1[] = new int[q - p + 1];
		int L2[] = new int[r - q];
		
		for (int i = 0; i < n1; i++) {
			L1[i] = A[p + i];
		}
		
		for (int i = 0; i < n2; i ++) {
			L2[i] = A[q + i + 1];
		}

		int i = 0;
		int j = 0;
		int k = p;
		while (i < n1 && j < n2) {
			if (L1[i] < L2[j]) {
				A[k] = L1[i];
				i++;
				k++;
			} else {
				A[k] = L2[j];
				j++;
				k++;
			}
		}
		
		/*
		 * Copy over the pending elements from L1 and L2
		 */
		while (i < n1) {
			A[k] = L1[i];
			k++;
			i++;
		}
		
		while (j < n2) {
			A[k] = L2[j];
			k++;
			j++;
		}
		
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MergeSort m = new MergeSort();
		
		int A[] = new int[]{1, 200, 400, 500, 900, 150, 250, 350, 700, 800};
		m.merge(A, 0, 4, 9);
		StringUtils.displayArray(A, "Merged array");
		
		int B[] = new int[]{1, 100, 2, 200, 3, 500, 400};
		m.mergeSort(B, 0, B.length - 1);
		StringUtils.displayArray(B, "Sorted array");
	}

	/**
	 * copy over to merge routine in case need to debug/dump the contents
	 * 
	 * 	StringUtils.displayArray(L1, "L1");
	 * StringUtils.displayArray(L2, "L2");
	 * StringUtils.displayArray(A, "Merged array");
	 * 
	 */

}
