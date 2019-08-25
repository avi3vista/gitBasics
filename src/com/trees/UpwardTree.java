package com.trees;

import com.trees.TreeBasics.TreeNode;

public class UpwardTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left_ptr = new TreeNode(2);
		root.left_ptr.left_ptr = new TreeNode(4);
		root.left_ptr.left_ptr.left_ptr = new TreeNode(6);
		
		root.right_ptr = new TreeNode(3);
		root.left_ptr.right_ptr = new TreeNode(5);
		root.left_ptr.left_ptr.right_ptr = new TreeNode(7);
		
		TreeNode head = flipUpsideDown(root);
		System.out.println(head);
		

	}
	public static TreeNode flipUpsideDown(TreeNode root){
        TreeNode[] head = new TreeNode[1];
        flipUpsideDown(root, null, head);
        return head[0];
    }
	
	private static void flipUpsideDown(TreeNode root, TreeNode parent, TreeNode[] head) {
		if(root==null) {
			return;
		}
		if(root.left_ptr !=null) {
			flipUpsideDown(root.left_ptr, root, head);
		}
		if(head[0]==null) {
			head[0] = root;
		}
		root.right_ptr = parent;
		if(parent!=null) {
			root.left_ptr = parent.right_ptr;
		}
		else {
			root.left_ptr = null;
		}
		
	}

	public static class TreeNode {
		int val;
		TreeNode left_ptr;
		TreeNode right_ptr;
		
		TreeNode(int val) {
			this.val=val;
		}
		
		@Override
		public String toString() {
			return String.valueOf(this.val);
		}
	}

}
