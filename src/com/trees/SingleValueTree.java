package com.trees;

import com.trees.TreeBasics.TreeNode;

public class SingleValueTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(5);
		root.right = new TreeNode(5);
		
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(5);
		
		root.left.left.left = new TreeNode(7);
		
		root.right.right = new TreeNode(5);
		
		System.out.println(findSingleValueTrees(root));

	}
	
	private static int findSingleValueTrees(TreeNode root) {
		int[] count = new int[1];
		
		findSingleValueTrees(root, count);
		
		return count[0];
	}

	private static boolean findSingleValueTrees(TreeNode root, int[] count) {
		if(root==null) {
			return false;
		}
		
		if(root.left==null && root.right==null) {
			count[0]++;
			return true;
		}
		boolean left = findSingleValueTrees(root.left, count);
		boolean right = findSingleValueTrees(root.right, count);
		
		if(root.left!=null && root.right==null && left  && root.val==root.left.val) {
			count[0]++;
			return true;
		}
		if(root.right!=null && root.left==null && right && root.val==root.right.val) {
			count[0]++;
			return true;
		}
		
		if(root.left!=null && root.right!=null && left && right && root.val==root.left.val && root.val==root.right.val) {
			count[0]++;
			return true;
		}
		
		
		return false;
	}

	static class TreeNode {
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
