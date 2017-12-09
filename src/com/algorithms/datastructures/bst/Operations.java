package com.algorithms.datastructures.bst;

public class Operations {
	
	public void insertNode(BST bst, TreeNode new_node) {
		TreeNode parent = null;
		TreeNode ptr = bst.head;
		
		while (ptr != null) {
			parent = ptr;
			if (new_node.data < ptr.data) {
				ptr = ptr.left;
			} else {
				ptr = ptr.right;
			}
		}
		
		new_node.parent = parent;
		
		/*
		 * If the tree was empty, initialize the current (which holds the value 'head'
		 * to new_node as the first node
		 */
		if (parent == null) {
			bst.head = new_node;
		} else if (new_node.data < parent.data) {
			parent.left = new_node;
		} else {
			parent.right = new_node;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
	}

}
