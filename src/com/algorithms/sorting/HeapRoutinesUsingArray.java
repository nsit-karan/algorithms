package com.algorithms.sorting;

import com.algorithms.misc.StringUtils;
import com.algorithms.misc.Utils;

/*
 * In case there is a use case to insert elements to the heap,
 * it is tedious to reallocate the memory yourself if using
 * array as the underlying DS
 */
public class HeapRoutinesUsingArray {
	
	/*
	 * Keeping all the members public to avoid (get/set)ers
	 * Just to keep the class concise
	 * 
	 * Good candidate for decorator pattern (just adding behavior)
	 */
	public static class Heap {
		
		public Integer heap_array[];
		public Integer heap_size;
		
		public Heap(Integer A[]) {
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
		
		if (left < heap.heap_size && (heap.heap_array)[left] > (heap.heap_array)[index]) {
			largest = left;
		} else {
			largest = index;
		}
		
		if (right < heap.heap_size && (heap.heap_array)[right] > (heap.heap_array)[largest]) {
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
		h.heap_size = h.heap_array.length;
		
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
		HeapRoutinesUsingArray heapRoutines = new HeapRoutinesUsingArray();
		heapRoutines.buildMaxHeap(h);
		StringUtils.displayArray(h.heap_array, "Heap after heapify is called");
		
		heapRoutines.heapSort(h);
		StringUtils.displayArray(h.heap_array, "Heap after heap sort");
		
	}

}
