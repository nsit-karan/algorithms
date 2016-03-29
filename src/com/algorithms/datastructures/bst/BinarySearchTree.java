package com.algorithms.datastructures.bst;

public class BinarySearchTree {
	
	public void insert(int x) {
	}
	
	/*
	 * complexity O(n) where the no of nodes is n
	 */
	public void inorderTreeWalk(Node ptr) {
		if (ptr != null) {
			inorderTreeWalk(ptr.left);
			System.out.println(ptr.x);
			inorderTreeWalk(ptr.right);
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
