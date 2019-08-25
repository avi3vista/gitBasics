package com.dataStructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.omg.PortableInterceptor.INACTIVE;

//Java program to find height of tree

//A binary tree node
class Node 
{
 int data;
 Node left, right;

 Node(int item) 
 {
     data = item;
     left = right = null;
 }
}

public class BinaryTree 
{
  Node root;
  static Node previousNode;

 /* Compute the "maxDepth" of a tree -- the number of 
    nodes along the longest path from the root node 
    down to the farthest leaf node.*/
 int maxDepth(Node node) 
 {
	 if(node!=null) {
		 System.out.println(node.data);
	 }
	 
     if (node == null)
         return 0;
     else
     {
         /* compute the depth of each subtree */
         int lDepth = maxDepth(node.left);
         int rDepth = maxDepth(node.right);

         /* use the larger one */
         if (lDepth > rDepth) {
             return (lDepth + 1);
         }
          else {
             return (rDepth + 1);
          }
     }
 }
 
//This method mainly calls insertRec()
 void insert(int key) {
    root = insertRec(root, key);
 }
  
 /* A recursive function to insert a new key in BST */
 Node insertRec(Node root, int key) {

     /* If the tree is empty, return a new node */
     if (root == null) {
         root = new Node(key);
         return root;
     }

     /* Otherwise, recur down the tree */
     if (key < root.data)
         root.left = insertRec(root.left, key);
     else if (key > root.data)
         root.right = insertRec(root.right, key);

     /* return the (unchanged) node pointer */
     return root;
 }
 
 
 public Node insertNode(Node root, int value) {
	 //Node node = new Node(value);
	 
	 if(root==null) {
		 root = new Node(value);
		 return root;
	 }
	 
	 if(root.data>value) {
		 root.left = insertNode(root.left,value);
	 }
	 else {
		root.right= insertNode(root.right,value);
	 }
	 
	 return root;
	 
 }
 
 public static boolean validateBST (Node root, int min, int max) {
	
	 if(root==null) {
         return true;
     }
     if(root.data<min || root.data>max) {
         return false;
     }
     return (validateBST(root.left, min, root.data-1) && validateBST(root.right, root.data+1, max));
	 
	 
 }
 
 
 public static boolean validateBSTInOrder (Node node, List resultList) {
	 if(node!=null && previousNode!=null) {
		 System.out.println(node.data + "    " + previousNode.data);
	 }
	 if(node==null) {
		 return true;
	 }
	 if(!validateBSTInOrder (node.left, resultList)) {
		return false; 
	 }
	 if(previousNode!=null && node.data<previousNode.data) {
		 resultList.add(node);
		 if(resultList.size()>2) {
			 return false;
		 }
		 return true;
		 
		 
	 }
	 previousNode = node;
	 
	 
	 return validateBSTInOrder(node.right, resultList);
 }
   
 

 	

private static List<String> tempTreeTraversal(Node root, List<String> resultList) {
	
	
	
	if(root!=null) {
		resultList.add(String.valueOf(root.data));
		tempTreeTraversal(root.left,resultList);
		tempTreeTraversal(root.right,resultList);
	}
	else {
		resultList.add("NULL");
	}
	
	
	
	
	return resultList;
	
}

private static void printKDistance(Node root, int k) {
	
	if(root==null) {
		return;
	}
	if(k==0) {
		System.out.print(root.data + "    ");
	}
	
	if(root.left !=null) {
		printKDistance(root.left, k-1);
	}
	if (root.right != null) {
		printKDistance(root.right, k-1);
	}
	
}

private static void printLevelOrder(Node root) {
	
	System.out.println("printing level order");
	Node s = root;
	
	Queue<Node> nodeQueue = new LinkedList<Node>();
	
	nodeQueue.add(s);
	while (!nodeQueue.isEmpty()) {
		s = nodeQueue.poll();
		if(s!=null) {
			System.out.print(s.data + "    ");
		}
		
		if(s.left !=null) {
			nodeQueue.add(s.left);
		}
		if(s.right!=null) {
			nodeQueue.add(s.right);
		}

	}
	
}

public static Node sortedArrayToBST(int[] nums) {
    if(nums == null || nums.length == 0 ) {
        return null;
    }
    Node root = new Node(nums[nums.length/2]);
    
    root = createBST(nums, 0, nums.length-1);
    return root;
}
public static Node createBST(int[] nums, int startIndex, int endIndex) {
    
    if( startIndex>endIndex ) {
        return null;
    }
    int mid = (endIndex+startIndex)/2;
    Node node = new Node(nums[mid]);
    node.left = createBST(nums, startIndex, mid-1);
    node.right = createBST(nums, mid+1, endIndex);
    
    return node;
}




/* Driver program to test above functions */
public static void main(String[] args) 
{
    BinaryTree tree = new BinaryTree();
    
    int nums[] = {-10,-3,0,5,9};
    Node root = sortedArrayToBST(nums);
    
    System.out.println("the root Node " + root.data);
    
    
    

   /* tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);
    tree.root.left.left.left = new Node(6);
    tree.root.left.left.left.right = new Node(7);*/
    
    
    
    /* Node root = tree.insertNode(null, 100);
    tree.root = root;
    tree.insert(1);
    tree.insert( 2);
    tree.insert(3);
    tree.insert( 4);
    tree.insert( 5);*/
    
    
    /*tree.insertNode(tree.root, 1);
    tree.insertNode(tree.root, 2);
    tree.insertNode(tree.root, 3);
    tree.insertNode(tree.root, 4);
    tree.insertNode(tree.root, 5);
    tree.root.left = new Node(4);
    tree.root.left.left = new Node(3);*/
    
    /*root.right=new Node(110);
    root.right.right = new Node(95);
    root.right.right.left = new Node(115);
    root.left= new Node(90);
    root.left.left = new Node(80);
    root.left.right = new Node(120);*/
    
    /* Let us create following BST
		     50
		  /     \
		 30      70
		/  \    /  \
		20   40  60   80 
*/
    
    tree.insert(50);
    tree.insert(30);
    tree.insert(20);
    tree.insert(40);
    tree.insert(70);
    tree.insert(60);
    tree.insert(80);
    
   // tree.root = new Node(2147483647);
    //tree.root.left = new Node(1);
    
    /*root.right= new Node(1);
    root.right.right = new Node(3);*/
    
    
   // List<Node> resultList = new ArrayList<Node>();

   // System.out.println("Is valid BST " + validateBST(tree.root,Integer.MIN_VALUE, Integer.MAX_VALUE));
    
   // System.out.println("Is valid BST " + validateBSTInOrder(root, resultList));
    
    //System.out.println(resultList.size());
    /*if(resultList.size()==1) {
        resultList.add(root);
    }
    
    int temp = resultList.get(0).data;
    resultList.get(0).data= resultList.get(1).data;
    resultList.get(1).data= temp;*/
    
    
    //printLevelOrder(tree.root);
    //System.out.println("Below are nodes at level 2");
    //printKDistance(tree.root, 2);
    
   // Node lca = leastCommonAncestor(tree.root, 40, 70);
}
}