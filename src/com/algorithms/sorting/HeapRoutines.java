package com.algorithms.sorting;

import java.util.ArrayList;

import com.algorithms.misc.StringUtils;
import com.algorithms.misc.Utils;


/*
 * Heap routines using array list.
 * Easier to insert/delete elements in the heap dynamically
 * without having to manage the memory yourself in case a
 * array was used
 */
public class HeapRoutines {
	
	/*
	 * Keeping all the members public to avoid (get/set)ers
	 * Just to keep the class concise
	 * 
	 * Good candidate for decorator pattern (just adding behavior)
	 */
	public static class Heap {
		
		public ArrayList<Integer> heap_array;
		public Integer heap_size;
		
		public Heap(Integer A[]) {
			this.heap_array = new ArrayList<Integer>();
			this.heap_size = 0;
			
			for (int i : A) {
				heap_array.add(i);
			}
		}
		
		/*
		 * Since index is starting from 2, diff from the straightforward impls:
		 * - 2i
		 * - 2i + 1
		 * - i/2
		 */
		public Integer getParentIndex(Integer index) {
			return ((index + 1)/ 2) - 1;
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
		
		if (left < heap.heap_size && heap.heap_array.get(left) > heap.heap_array.get(index)) {
			largest = left;
		} else {
			largest = index;
		}
		
		if (right < heap.heap_size && heap.heap_array.get(right) > heap.heap_array.get(largest)) {
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
		h.heap_size = h.heap_array.size();
		
		for (int i = h.heap_size / 2; i >= 0; i--) {
			maxHeapify(h, i);
		}
	}
	
	public void heapSort(Heap h) {
		buildMaxHeap(h);
		
		for (int i = h.heap_size - 1; i > 0; i--) {
			Utils.swap(h.heap_array, 0, i);
			h.heap_size = h.heap_size - 1;
			maxHeapify(h, 0);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Heap h = new Heap(new Integer[] {4, 1, 3, 2, 16, 9, 10});
		
		StringUtils.displayArray(h.heap_array, "Heap before heapify is called");
		HeapRoutines heapRoutines = new HeapRoutines();
		heapRoutines.buildMaxHeap(h);
		StringUtils.displayArray(h.heap_array, "Heap after heapify is called");
		
		heapRoutines.heapSort(h);
		StringUtils.displayArray(h.heap_array, "Heap after heap sort");
		
	}

}
