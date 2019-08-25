package com.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeBasics {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left=new TreeNode(1);
		root.right= new TreeNode(4);
		
//		root.left.left = new TreeNode(100);
		root.left.right = new TreeNode(2);
		
	//	root.right.left = new TreeNode(30);
	//	root.right.right = new TreeNode(18);
		
	//	root.right.left.left = new TreeNode(180);
		
		/*dfsPreOrder(root);

		System.out.println();
		
		dfsUsingStack(root);
		System.out.println();
		
		dfsInOrder(root);
		System.out.println();
		
		dfsPostOrder(root);
		
		
		System.out.println();
		bfsUsingQueue(root);*/
		
		int[] preorder = {21,15,10,17,45,30,35,55,60};
		int[] inorder = {10,15,17,21,30,35,45,55,60};
		//TreeNode res = buildTree(preorder, inorder);
		
		//System.out.println(res);
		
		//System.out.println(kthSmallest(root, 1));
		
		dfsPostOrder(root);
		
		
		
		System.out.println(dfsPostOrderIterative(root));

	}
	
	private static List<Integer> dfsPostOrderIterative(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		
		if (root==null) {
			return res;
		}
		s.add(root);
		TreeNode temp = root;
		while(!s.isEmpty()) {
			temp = s.peek();
			if(temp.right!=null) {
				s.push(temp.right);
			}
			if(temp.left!=null) {
				s.push(temp.left);
			}
			res.add(s.pop().val);
		}
		return res;
		
	}

	private static int kthSmallest(TreeNode root, int k) {
		 int[] res = new int[2];
	        res[0] = k;
	        
	        inorderTraversal(root, res);
	        
	        return res[1];
	}
	
	 public static void inorderTraversal(TreeNode root, int[] res) {
	        if(root==null) {
	            return;
	        }
	        inorderTraversal(root.left, res);
	        res[0]--;
	        if(res[0]==0) {
	            res[1] = root.val;
	            return;
	        }
	        inorderTraversal(root.right, res);
	    }

	private static TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildTree(preorder, inorder, 0, preorder.length-1, 0, preorder.length-1);
	}

	private static TreeNode buildTree(int[] preorder, int[] inorder, int i, int j, int m, int n) {
		if(i<0 || i>=preorder.length|| j>=preorder.length || m<0 || n>=inorder.length) {
			return null;
		}
		
		TreeNode root = new TreeNode(preorder[i]);
		if(i==j) {
			return root;
		}
		
		int inorderStart = m;
		int index=0;
		for(index=0; index+i<j; index++) {
			if(inorder[index+inorderStart]==preorder[i]) {
				break;
			}
		}
		
		root.left = buildTree(preorder, inorder, i+1, i+index, m, m+index);
		root.right= buildTree(preorder, inorder, i+index+1, j, m+index+1, n);
		
		
		return root;
		
	}

	private static void dfsUsingStack(TreeNode root) {
		if(root==null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode tempNode = null;
		while(!stack.isEmpty()) {
			tempNode = stack.pop();
			
			if(tempNode.right!=null) {
				stack.push(tempNode.right);
			}
			if(tempNode.left!=null) {
				stack.push(tempNode.left);
			}
			System.out.print(tempNode + "  ");
		}
		
	}

	private static void bfsUsingQueue(TreeNode root) {
		Queue<TreeNode> temp = new LinkedList<TreeNode>();
		if(root!=null) {
			temp.add(root);
		}
		TreeNode tempNode = null;
		while(!temp.isEmpty()) {
			tempNode = temp.poll();
			if(tempNode.left!=null) {
				temp.add(tempNode.left);
			}
			if(tempNode.right!=null) {
				temp.add(tempNode.right);
			}
			System.out.print(tempNode + "  ");
		}
	}

	private static void dfsPostOrder(TreeNode root) {
		if(root==null) {
			return;
		}
		dfsPostOrder(root.left);
		dfsPostOrder(root.right);
		System.out.print(root + "  ");
		
	}

	private static void dfsInOrder(TreeNode root) {
		if(root==null) {
			return;
		}
		dfsInOrder(root.left);
		System.out.print(root + "  ");
		dfsInOrder(root.right);
		
	}

	private static void dfsPreOrder(TreeNode root) {
		if(root==null) {
			return;
		}
		
		System.out.print(root + "  ");
		dfsPreOrder(root.left);
		dfsPreOrder(root.right);
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
