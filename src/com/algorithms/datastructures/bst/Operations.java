package com.algorithms.datastructures.bst;

public class Operations {
	
	public void insertNode(BinarySearchTree bst, TreeNode new_node) {
		TreeNode y = null;
		TreeNode ptr = bst.head;
		
		while (ptr != null) {
			y = ptr;
			if (new_node.x < ptr.x) {
				ptr = ptr.left;
			} else {
				ptr = ptr.right;
			}
		}
		
		new_node.parent = y;
		
		/*
		 * If the tree was empty, initialize the current (which holds the value 'head'
		 * to new_node as the first node
		 */
		if (y == null) {
			bst.head = new_node;
		} else if (new_node.x < y.x) {
			y.left = new_node;
		} else {
			y.right = new_node;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

}
