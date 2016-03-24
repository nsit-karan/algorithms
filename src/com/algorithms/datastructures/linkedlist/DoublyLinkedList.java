package com.algorithms.datastructures.linkedlist;

/*
 * Not adding the code for trivial add/delete/search
 * for a node here.
 * 
 * To avoid having ugly spacial cases for terminal scenarios(like
 * deletion of the last node, adding the first node, etc), we use
 * a dummy node.
 * 
 * This dummy node follows the last node in the list and precedes the
 * first no in the list. In this way, the doubly linked list is converted
 * to a cyclic list.
 * 
 * The above removes the need to put complex edge conditions.
 */
public class DoublyLinkedList {
	
	Node dummy;
	
	public DoublyLinkedList() {
		dummy = new Node();
		dummy.next = dummy;
		dummy.prev = dummy;
	}

}
