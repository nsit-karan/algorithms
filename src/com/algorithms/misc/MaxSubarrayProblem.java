package com.algorithms.misc;

/**
 * Given an array, find the subarray with the max sum
 * Approach:
 * - Iterate over the array from index 1:
 *   - at every iteration, either the max subarray will be within (0,j-1) or
 *     will be A[i,j] where A[..j-1] is maintained as another var.
 *     This var has the max sum possible where the sub-array needs to end at j
 *     
 * - avoiding get/setet here for better readibility
 *
 */
public class MaxSubarrayProblem {
		
	public MaxSubArray calculateMaxSubArray(int A[]) {
		MaxSubArray maxSubArray = new MaxSubArray(0, 0, A[0]);
		MaxSubArray jSubArray = new MaxSubArray(0, 0, A[0]);
		
		for (int i = 1; i < A.length; i++) {
			int prev_i_sum = jSubArray.sum;
			int max_sum = maxSubArray.sum;
			
			if (prev_i_sum + A[i] > A[i]) {
				jSubArray.endIndex = i;
				jSubArray.sum = prev_i_sum + A[i];
			} else {
				jSubArray.updateValues(i, i, A[i]);
			}
			
			if (jSubArray.sum > max_sum) {
				maxSubArray.updateValues(jSubArray);
			}
		}
		
		return maxSubArray;
	}
	
	public static class MaxSubArray {
		
		int startIndex;
		int endIndex;
		int sum;
		
		public MaxSubArray(int startIndex, int endIndex, int sum) {
			this.startIndex = startIndex;
			this.endIndex = endIndex;
			this.sum = sum;
		}
				
		public void updateValues(MaxSubArray newValue) {
			this.startIndex = newValue.startIndex;
			this.endIndex = newValue.endIndex;
			this.sum = newValue.sum;
		}
		
		public void updateValues(int start_index, int end_index, int new_sum) {
			this.startIndex = start_index;
			this.endIndex = end_index;
			this.sum = new_sum;
		}

	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MaxSubarrayProblem ms = new MaxSubarrayProblem();
		int A[] = new int[] {1, 10, 20, -1, -4, 100, -100, -20, 10};
		MaxSubArray max = ms.calculateMaxSubArray(A);
		System.out.printf("max subarry is from %d to %d and max sum is %d\n", max.startIndex, max.endIndex, max.sum);
		
		A = new int[] {-1, 1, 10, 20, -1, -4, 100, -100, -20, 10};
		max = ms.calculateMaxSubArray(A);
		System.out.printf("max subarry is from %d to %d and max sum is %d\n", max.startIndex, max.endIndex, max.sum);
		
		A = new int[] {2, -2, -2, -2, -2, 8};
		max = ms.calculateMaxSubArray(A);
		System.out.printf("max subarry is from %d to %d and max sum is %d", max.startIndex, max.endIndex, max.sum);


	}

}
