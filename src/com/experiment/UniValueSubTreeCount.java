package com.experiment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
	int val;
	Node left;
	Node right;
	public int getValue() {
		return val;
	}
	public void setValue(int value) {
		this.val = value;
	}
	public Node getLeftNode() {
		return left;
	}
	public void setLeftNode(Node leftNode) {
		this.left = leftNode;
	}
	public Node getRightNode() {
		return right;
	}
	public void setRightNode(Node rightNode) {
		this.right = rightNode;
	}
	public Node(int value) {
		super();
		this.val = value;
	}
	
	

	
}

public class UniValueSubTreeCount {

	public static void main(String[] args) {
		
		Node root = new Node(10);
		root.left= new Node(20);
		root.right = new Node(30);
		
		root.left.left = new Node(40);
		root.left.right = new Node(50);
		
		root.right.left = new Node(60);
		root.right.right = new Node(70);
		
		//BFSTraversal(root);
		
		int singleCount = checkUniValue(root);
		
		System.err.println("the number of uniSubTree = " + singleCount);

	}
	
	
	private static int checkUniValue(Node root) {
		int singleCount = 0;
		List<Node> bfsArray = BFSTraversal(root);
		
		for(int i=0; i<bfsArray.size() ; i++) {
			System.out.print(bfsArray.get(i)==null ? "null    " : bfsArray.get(i).val + "            ");
		}
		System.out.println();
		
		for(int i=1; i<=bfsArray.size()-1; i++) {
			Boolean isUniValue = true;
			isUniValue = bfsArray.get(i)==null ? false :uniValue(i, bfsArray, i, isUniValue);
			if(isUniValue) {
				int childrenCount = markChildNullAndGetCount(bfsArray,i);
				singleCount+=childrenCount;
			}
			
			System.out.println("the UniValue for current Index " + i +" = " + isUniValue);

		}
		return singleCount;
		
	}


	private static int markChildNullAndGetCount(List<Node> bfsArray, int currentIndex) {
		int[] count = new int[1];
		
			markNullAndIncrementCount(bfsArray, currentIndex, count);
		return count[0];
		
	}


	private static void markNullAndIncrementCount(List<Node> bfsArray, int currentIndex, int[] count) {
		if(currentIndex>=bfsArray.size()) {
			return;
		}
		if(bfsArray.get(currentIndex)!=null) {
			count[0]++;
			bfsArray.set(currentIndex,null);
		}
		markNullAndIncrementCount(bfsArray, currentIndex*2, count);
		markNullAndIncrementCount(bfsArray, currentIndex*2+1, count);
		
	}


	private static boolean uniValue(int originalIndex, List<Node> bfsArray, int currentIndex, Boolean isUniValue) {
		if(!isUniValue || currentIndex>=bfsArray.size() || bfsArray.get(currentIndex)==null) {
			return isUniValue;
		}
		isUniValue = bfsArray.get(originalIndex).val==bfsArray.get(currentIndex).val
				&&   uniValue(originalIndex, bfsArray, currentIndex*2, isUniValue)
				&&   uniValue(originalIndex, bfsArray, currentIndex*2+1, isUniValue);
		
		return isUniValue;
		
	}


	private static Node[] getBFS(Node root) {
		
		Node[] nodeArray = new Node[7];
		
		nodeArray[0]=null;
		
		
		nodeArray[1]=new Node(5);
		nodeArray[2]=new Node(5);
		nodeArray[3]=new Node(5);
		nodeArray[4]=new Node(5);
		nodeArray[5]=new Node(5);
		nodeArray[6]=new Node(5);
		/*nodeArray[7] = null;*/
		
		return nodeArray;
	}


	private static List<Node> BFSTraversal(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		List<Node> bfsList = new ArrayList<Node>();
		if(root==null) {
			return bfsList;
		}
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Node currentNode = queue.poll();
			bfsList.add(currentNode);
			
			if(currentNode.left!=null) {
				queue.add(currentNode.left);
			}
			
			if(currentNode.right !=null) {
				queue.add(currentNode.right);
			}
		}
		return bfsList;
		
	}

}
