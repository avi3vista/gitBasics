package com.trees;

public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(9);
		root.left= new TreeNode(6);
		root.right = new TreeNode(-3);
		
		root.right.left = new TreeNode(-6);
		root.right.right = new TreeNode(2);
		root.right.right.left = new TreeNode(2);
		root.right.right.left.left = new TreeNode(-6);
		root.right.right.left.left.left = new TreeNode(-6);
		root.right.right.left.right = new TreeNode(-6);
		
		System.out.println(maxPathSum(root));

	}
	
	 public static int maxPathSum(TreeNode root) {
	        Res res = new Res();
	        if(root!=null) {
	        	res.max = root.val;
	        }
	        maxPathSum(root, res);
	        
	        return res.max;
	    }
	 
	 private static int maxPathSum(TreeNode root, Res res) {
		 if(root==null) {
			 return 0;
		 }
		 
		 /*int side = Math.max(root.val, root.val + Math.max(left, right));
		 res.max = Math.max(side, res.max);
		 res.max = Math.max(res.max, root.val+ maxPathSum(root.left, res) + maxPathSum(root.right,res));*/
		 
		 int left = maxPathSum(root.left, res);
		 int right = maxPathSum(root.right,res);
		 
		 int side = Math.max(root.val, root.val + Math.max(left,right));
		 //res.max = Math.max(side, res.max);
		 res.max = Math.max(Math.max(side, res.max), root.val+ left + right);
		 return side;
		 
		
	}

	static class TreeNode {
		    int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		      
		      @Override
		    public String toString() {
		    String res = String.valueOf(this.val);
		    return res;
		    }
		  }

	 static class Res {
		 int side;
		 int max;
		 
		 @Override
		public String toString() {
			 String res = "side = " + side + "  Max = " + max ;
			 return res;
		}
		 
	 }
}
