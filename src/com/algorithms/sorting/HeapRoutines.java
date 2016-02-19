package com.algorithms.sorting;

import com.algorithms.misc.StringUtils;
import com.algorithms.misc.Utils;

public class HeapRoutines {
	
	/*
	 * Keeping all the members public to avoid (get/set)ers
	 * Just to keep the class concise
	 * 
	 * Good candidate for decorator pattern (just adding behavior)
	 */
	public static class Heap {
		
		Integer heap_array[];
		Integer heap_size;

		public Heap(int A[]) {
			this.heap_array = new Integer[A.length];
			this.heap_size = 0;
			
			int count = 0;
			for (int i : A) {
				heap_array[count] = i;
				count++;
			}
		}
		
		public Integer getParentIndex(Integer index) {
			return index / 2;
		}
		
		public Integer getLeftIndex(Integer index) {
			return 2 * index + 1;
		}
		
		public Integer getRightIndex(Integer index) {
			return 2 * index + 2;
		}
		
	}
	
	/**
	 * Heapify the 'heap' starting at 'index',i.e,
	 * heapify it for all nodes below the index
	 * 
	 * This assumes that Left(i) and right(i) are already max-heaps
	 * and only 'index' node needs to be put in its correct place
	 * 
	 * @param heap
	 * @param index
	 */
	public void maxHeapify(Heap heap, Integer index) {
		int left = heap.getLeftIndex(index);
		int right = heap.getRightIndex(index);
		int largest = 0;
		
		
		
		if (left <= heap.heap_size && (heap.heap_array)[left] > (heap.heap_array)[index]) {
			largest = left;
		} else {
			largest = index;
		}
		
		if (right <= heap.heap_size && (heap.heap_array)[right] > (heap.heap_array)[largest]) {
			largest = right;
		}
		
		/*
		 * If largest is different from the node under consideration:
		 * implies that heapify needs to be called again with index or node
		 * underconsideration set to largest
		 */
		if (largest != index) {
			Utils.swap(heap.heap_array, index, largest);
			maxHeapify(heap, largest);
		}
	}
	
	public void buildMaxHeap(Heap h) {
		h.heap_size = h.heap_array.length - 1;
		
		for (int i = h.heap_array.length / 2; i >= 0; i--) {
			maxHeapify(h, i);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Heap h = new Heap(new int[] {4, 1, 3, 2, 16, 9, 10});
		
		StringUtils.displayArray(h.heap_array, "Heap before heapify is called");
		HeapRoutines heapRoutines = new HeapRoutines();
		heapRoutines.buildMaxHeap(h);
		StringUtils.displayArray(h.heap_array, "Heap after heapify is called");
	}

}
