package com.algorithms.datastructures.array;

import com.algorithms.misc.StringUtils;
import com.algorithms.misc.Utils;

public class RotateArray {
	
	/*
	 * Rotate array by 1 to the left.
	 * What this implies is that A[i] = A[i+1]
	 * To handle edge cases, instead of initializing A[i] to A[i+1],
	 * instead swap the 2. This will ensure that A[0] reaches the end of the array,i.e
	 * rolves over to the end of the array
	 * 
	 * 0,1,2,3,4,5
	 * After first iteration:
	 * - 1,0,2,3,4,5
	 */
	public void rotateArray(int A[]) {
		for (int i = 0; i < A.length - 1; i++) {
			Utils.swap(A, i, i + 1);
		}
	}
	
	public void rotateArrayN(int A[], int n_count) {
		for (int i = 0; i < n_count; i++) {
			rotateArray(A);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int A[] = new int[]{0, 1, 2, 3, 4, 5};
		RotateArray ra = new RotateArray();
		ra.rotateArrayN(A, 3);
		
		StringUtils.displayArray(A, "After rotation");
	}

}
