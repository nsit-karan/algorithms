package com.algorithms.datastructures.linkedlist;

/*
 * Stack using linked list:
 *   - push-->insert / pop-->delete
 */
public class SingleLinkedList {
	
	Node head;
	Node tail;
	
	/**
	 * Inserts an element at the head of the list
	 * 
	 * Special case:
	 * - initiliaze tail to 'u' if tail was uninitialized
	 */
	public void push(int x) {
		Node new_node = new Node(x);
		new_node.next = head;
		head = new_node;
		
		if (tail == null) {
			tail = new_node;
		}
	}
	
	/**
	 * Delete the head and update head
	 * Boundary conditions:
	 * - list empty
	 * - last element deleted:
	 *    - head = head.next takes care of making head null
	 *    - tail needs to be set to null if head becomes null
	 */
	public int pop() {
		if (head == null) {
			throw new RuntimeException("Empty list");
		}
		
		int x = head.x;
		head = head.next;
		
		if (head == null) {
			tail = null;
		}
		return x;
	}
	
	/**
	 * Insertions are done at the end of the list
	 * Corner case: If head/tail is null, then initialize both to
	 * the new element
	 */
	public void insert(int x) {
		if (head == null) {
			head = tail = new Node(x);
		} else {
			Node n = new Node(x);
			tail.next = n;
			tail = n;
		}
	}
	
	/**
	 * Delete from the tail of the list
	 * For this, need to iterate till i.next.next != null.
	 * 
	 * The above condition makes sure that once the loop ends,
	 * the iter is at 1 node before the tail.
	 * 
	 * For instance:
	 * |a|->|b|->|c|->|d|->|e|
	 * In the above, once the loop ends, iter holds reference to |d|.
	 * So, tail is reset to refer to |d| and
	 * iter.next is set to null
	 * 
	 * Using the above reference, the last element can be deleted
	 * 
	 * Edge condition:
	 * - in case only 1 element is there, first check whether head.next == null.
	 *   If that is the case, then only 1 element
	 * - in case 1 elements, head == null, no-op  
	 */
	public int delete() {
		if (isEmpty()) {
			throw new RuntimeException("List empty : no element to delete");
		} else if (head.next == null) {
			/*
			 * Only 1 element exists
			 */
			int x = head.x;
			head = tail = null;
			return x;
		} else {
			Node iter = head;
			while (iter.next.next != null) {
				iter = iter.next;
			}
			int x = iter.next.x;
			iter.next = null;
			tail = iter;
			return x;
		}
	}
	
	public int size() {
		if (isEmpty()) {
			return 0;
		}
		
		int count = 0;
		Node iter = this.head;
		while (iter != null) {
			iter = iter.next;
			count++;
		}
		return count;
	}
	
	public boolean isEmpty() {
		return head == null ? true : false;
	}
	
	public void displayList(String loggerString) {
		StringBuilder sb = new StringBuilder(loggerString).append(" : ");
		Node iter = head;
		while (iter != null) {
			sb.append(iter.x).append(" -> ");
			iter = iter.next;
		}
		
		/*
		 * strip off the trailing extra '->'
		 */
		if (!isEmpty()) {
			sb.delete(sb.toString().length() - 4, sb.toString().length());
		}
		System.out.printf("%s | (size = %d)\n", sb.toString(), this.size());
	}

	/*
	 * Expected O/P:
	 * 
	 * sl : 3 -> 2 -> 1 | (size = 3)
	 * Element deleted : 3
	 * sl : 2 -> 1 | (size = 2)
	 * sl :  | (size = 0)
	 * sl : 10 -> 20 -> 30 | (size = 3)
	 * sl : 10 | (size = 1)
	 * 
	 */
	public static void main(String[] args) {
		SingleLinkedList sl = new SingleLinkedList();
		sl.push(1);
		sl.push(2);
		sl.push(3);
		
		sl.displayList("sl");		
		System.out.printf("Element deleted : %d\n", sl.pop());
		sl.displayList("sl");
		sl.pop();
		sl.pop();
		sl.displayList("sl");
		
		sl.insert(10);
		sl.insert(20);
		sl.insert(30);
		sl.displayList("sl");
		
		sl.delete();
		sl.delete();
		sl.displayList("sl");

	}

}
