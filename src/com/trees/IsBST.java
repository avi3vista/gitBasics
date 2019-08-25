package com.trees;

import com.trees.TreeBasics.TreeNode;

public class IsBST {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(3);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(4);
		
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		
		//root.right.right = new TreeNode(3);
		
		System.out.println(isBST(root));
		

	}
	
	private static boolean isBST(TreeNode root) {
		Integer max = null;
	    Integer min = null;
        return isBST(root, min, max);
		
	}
	
	static boolean isBST(TreeNode root, Integer min, Integer max){
	    if(root==null) {
			return true;
		}
		boolean left = true;
		boolean right  = true;
		if(min!=null) {
		    left = left && root.val>min;
		}
		if(root.left!=null) {
			left = isBST(root.left, min, root.val);
			
			left = left && root.val>=root.left.val;
			 
		}
		if(max!=null) {
		    right = right && root.val<max;
		}
		if(root.right!=null) {
			right = isBST(root.right, root.val, max );
			
			right = right && root.val<=root.right.val;
		}
		
		
		return left&&right;
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int val) {
			this.val=val;
		}
		
		@Override
		public String toString() {
			return String.valueOf(this.val);
		}
	}

}
