package com.trees;

import java.util.ArrayList;
import java.util.List;

public class NaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		Node root = new Node(1, new ArrayList<Node>());
		root.children.add(new Node(3,new ArrayList<Node>()));
		root.children.add(new Node(2,new ArrayList<Node>()));
		root.children.add(new Node(4,new ArrayList<Node>()));
		
		root.children.get(0).children.add(new Node(5,new ArrayList<Node>()));
		root.children.get(0).children.add(new Node(6,new ArrayList<Node>()));
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		dfs(root, res, 0);
		
		System.out.println(res);
		
		List<Integer> preOrder = new ArrayList<Integer>();
		
		preorder(root,preOrder);
		System.out.println(preOrder);

	}
	
	

	private static void preorder(Node root, List<Integer> preOrder) {
		
		if(root==null) {
			return;
		}
		preOrder.add(root.val);
		for(Node child : root.children) {
			preorder(child, preOrder);
		}
		
	}



	private static void dfs(Node root, List<List<Integer>> res, int k) {
		if(root==null) {
			return;
		}
		if(res.size()<=k) {
			res.add(new ArrayList<Integer>());
		}
		res.get(k).add(root.val);
		
		for(Node child : root.children) {
			dfs(child, res, k+1);
		}
		
	}



	static class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
}
}
