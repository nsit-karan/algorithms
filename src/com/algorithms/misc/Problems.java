package com.algorithms.misc;


/**
 * 
 * Count inversion in a given array:
 * - a pair is inverted if i < j but A[i] > A[j]
 * 
 * Algo1:
 * - as part of insertion sort, whenever a swap is needed, the the indices involved are inverted
 * - complexity : O(n^2)
 * Algo2:
 * - as part of merge sort, whenever item from right array is selected, then all the items left in
 * the left sub-array form an inversion.
 * - complexity : O( nLog(n) )
 *
 */
public class Problems {
	
	/**
	 * How do we calculate the volume of an irregular object, say a light bulb or a wierdly shaped earthen
	 * pot?
	 * 
	 * Sn: Use the archiemedes way !!
	 * Fill the object with water and empty out the water into a cubical box.
	 * The volume will be thus : lenght*breadth*height_water
	 * 
	 */
	void calculateVolume() {}

}
