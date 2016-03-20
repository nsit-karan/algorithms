package com.algorithms.datastructures.queue;

import com.algorithms.misc.StringUtils;

/*
 * Queue implemeted using a array of fixed size
 * Can use arrayList if size limitation needs to be removed
 * 
 * head : holds the elemenet which was inserted earliest and will be the first
 *        element to be dequeed
 * 
 * tail : holds the index where the element was last inserted.
 * 
 * Queue elements are from index:
 * head, head + 1, head + 2,.........., tail
 * 
 * tail wraps around to the beginning of the array and uses the array
 * as a circular structure
 */
public class ArrayQueue {
	
	int Q[] = new int[5];
	int head = -1;
	int tail = -1;
	
	/*
	 * After insertion, if tail was at len-1 position,
	 * initialize tail = 0 so that next insertion happens there.
	 */
	public void enqueue(int x) {
		
		/*
		 * 2 edge scenarios:
		 * - head is at initial position and tail has maxed out(reached end of array)
		 * - tail + 1 leads to head(must have wrapped around once)
		 */
		if ((head == 0 && tail == Q.length - 1)
				|| (head == tail + 1)) {
			throw new RuntimeException("Can't enqueue : queue full, element tried : " + x);
		}

		if (tail == Q.length - 1) {
			tail = 0;
		} else {
			tail++;
		}
		Q[tail] = x;
		
		/*
		 * If head wasn't initilaized, initiliaze head to 0
		 */
		if (head < 0) {
			head = 0;
		}
	}
	
	/*
	 * return the element at Q[head].
	 */
	public int dequeue() {
		if (this.head < 0) {
			throw new RuntimeException("Cannot dequeue : queue empty");
		}

		/*
		 * Initialize Q[head] to -1(signals a index which
		 * doesn't hold any value/useful while debugging
		 * to figure out which are the indices with valid
		 * data)
		 */
		int x = Q[head];
		Q[head] = -1;
		
		/*
		 * Head == tail implies that only 1 element is left
		 * So, initiliaze head/tail to -1
		 * 
		 * Else, if head has reached the end, wrap around to the beginning
		 * of the array, i.e, head = 0
		 * 
		 * Else, increment head by 1.
		 * 
		 * Rem : head holds the index of the element which will be dequed in the next
		 * call
		 */
		if (head == tail) {
			head = tail = -1;
		} else if (head == Q.length - 1) {
			head = 0;
		} else {
			head = head + 1;
		}
		return x;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayQueue q = new ArrayQueue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		
		try {
			q.enqueue(100);
		} catch (RuntimeException e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		/*
		 * Will display 1,2, 3, 4, 5
		 */
		StringUtils.displayArray(q.Q, "Queue elements from head to tail");
		
		System.out.printf("element dequeed : %d, again dequeu : %d\n", q.dequeue(), q.dequeue());
		q.dequeue();
		q.dequeue();
		q.dequeue();
		
		StringUtils.displayArray(q.Q, "Queue elements from head to tail");

		try {
			q.dequeue();
		} catch (RuntimeException e) {
			System.out.println(e.getLocalizedMessage());
		}

	}

}
