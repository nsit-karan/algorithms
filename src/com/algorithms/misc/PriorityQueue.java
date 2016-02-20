package com.algorithms.misc;

import com.algorithms.sorting.HeapRoutines;
import com.algorithms.sorting.HeapRoutines.Heap;


/**
 * Priority queue using heaps
 * 
 */
public class PriorityQueue {
	
	Heap heap;
	
	public PriorityQueue(Heap heap) {
		this.heap = heap;
	}
	
	public Integer maxElement() {
		return heap.heap_array.get(0);
	}
	
	/*
	 * Remove the element with max key and heapify
	 */
	public Integer extractMax() {
		if (heap.heap_size <= 0) {
			return -1;
		}
		
		Integer max = heap.heap_array.get(0);
		heap.heap_array.set(0, heap.heap_array.get(heap.heap_size - 1));
		heap.heap_array.remove(heap.heap_size - 1);
		
		heap.heap_size = heap.heap_size - 1;
		
		new HeapRoutines().maxHeapify(this.heap, 0);
		return max;
	}
	
	/*
	 * Increase the value at index 'i' to key.
	 * This implies that the parent of 'i' might be lesser now.
	 * So, need to look up,i.e., go on correcting the parent heierarchy
	 * till the correct spot is found
	 */
	public void increaseKey(Integer i, Integer key) {
		if (key < heap.heap_array.get(i)) {
			System.out.println("ERROR : key should be greater!!");
		}
		
		heap.heap_array.set(i, key);
		
		while (i > 0 && heap.heap_array.get(heap.getParentIndex(i)) < heap.heap_array.get(i)) {
			
			Utils.swap(heap.heap_array, i, heap.getParentIndex(i));
			i = heap.getParentIndex(i);
		}
		
	}
	
	public void insertElement(Integer key) {
		heap.heap_array.add(-1);
		heap.heap_size = heap.heap_size + 1;
		increaseKey(heap.heap_size - 1, key);
	}
	
	/*
	 * - initialize heap[index] = heap[last_element]
	 * - reduce heap size by 1
	 * - call heapify again
	 */
	public void deleteElement(Integer index) {
		
		Integer last_element = heap.heap_array.get(heap.heap_size - 1);
		heap.heap_array.set(index, last_element);
		heap.heap_array.remove(heap.heap_size - 1);
		heap.heap_size = heap.heap_size - 1;
		
		new HeapRoutines().maxHeapify(heap, index);
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

		PriorityQueue pq = new PriorityQueue(h);
		pq.extractMax();
		
		StringUtils.displayArray(h.heap_array, "Heap after extract max is called(ignore the last element)");
		
		pq.increaseKey(1, 20);
		StringUtils.displayArray(h.heap_array, "Heap after increasing elemet at index 1");
		
		pq.insertElement(12);
		StringUtils.displayArray(h.heap_array, "Heap after inserting new element with value 12");
		
		pq.deleteElement(0);
		StringUtils.displayArray(h.heap_array, "Heap after deleting element at index 0");
	}

}
