package com.experiment;

import java.beans.DesignMode;
import java.util.ArrayList;
import java.util.List;

public class TreeBasics {

	public static void main(String[] args) {
		Node root = new Node(4);
		root.left= new Node(2);
		root.left.left = new Node(3);
		
		root.left.right = new Node(1);
		
		root.left.right.left = new Node(5);
		
		root.right = new Node(10);
		root.right.left = new Node(9);
		
		int[] a = {1,2,3,4,5};
		//printAllPathFromRootToLeaf(root);
		/*
		List<Node> path1 = getPath(root, root.right.left);
		List<Node> path2 = getPath(root, root.left.right);
		
		int index = 0;
		while(index<path1.size() && index<path2.size()) {
			if(path1.get(index).val==path2.get(index).val) {
				index++;
			}
			else {
				break;
			}
		}
		System.out.println(path1.get(index-1).val);*/
//		build_balanced_bst(a);
		//System.out.println(kth_smallest_element(root, 3));
	
		//System.out.println("Diameter = " + diameterOfBinaryTree(root));
		System.out.println();
		displayTree(root);
		
		//invertBinaryTree(root);
		
		//displayTree(root);
		System.out.println("==========================================================================================");
		
		Node root2 = new Node(100);
		root2.left = new Node(99);
		root2.right = new Node(101);
		root2.left.left = new Node(97);
		root2.left.right = new Node(98);
		
		displayTree(root2);
		System.out.println("==========================================================================================");	
		
		
		root = mergeBinaryTree(root, root2);
		
		displayTree(root);

	}
	
	private static Node mergeBinaryTree(Node root, Node root2) {
		if(root==null && root2==null) {
			return root;
		}
		if(root==null) {
			return root2;
		}
		if(root2==null) {
			return root;
		}
		root.left = mergeBinaryTree(root.left, root2.left);
		root.right = mergeBinaryTree(root.right, root2.right);
		root.val = root.val + root2.val;
		return root;
		
		
	}

	private static void invertBinaryTree(Node root) {
		if(root==null) {
			return;
		}
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		invertBinaryTree(root.left);
		invertBinaryTree(root.right);
		
	}

	public static void displayTree(Node root) {
        final int height = 5, width = 64;
 
        int len = width * height * 2 + 2;
        StringBuilder sb = new StringBuilder(len);
        for (int i = 1; i <= len; i++)
            sb.append(i < len - 2 && i % width == 0 ? "\n" : ' ');
 
        displayR(sb, width / 2, 1, width / 4, width, root, " ");
        System.out.println(sb);
    }
 
    private static void displayR(StringBuilder sb, int c, int r, int d, int w, Node n,
            String edge) {
        if (n != null) {
            displayR(sb, c - d, r + 2, d / 2, w, n.left, " /");
 
            String s = String.valueOf(n.val);
            int idx1 = r * w + c - (s.length() + 1) / 2;
            int idx2 = idx1 + s.length();
            int idx3 = idx1 - w;
            if (idx2 < sb.length())
                sb.replace(idx1, idx2, s).replace(idx3, idx3 + 2, edge);
 
            displayR(sb, c + d, r + 2, d / 2, w, n.right, "\\ ");
        }
    }
	
	 private static int diameterOfBinaryTree(Node root) {
		 if(root==null) {
			 return 0;
		 }
		 int rootDia = diameterOfRoot(root);
		 int childrenDia = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
		 return Math.max(rootDia, childrenDia);
		
	}

	private static int diameterOfRoot(Node root) {
		 int[] count = {0};
		 if(root==null) {
			 return count[0];
		 }
		 if(root!=null) {
			 count[0]++;
		 }
		 if(root.left!=null) {
			 findNumberOfLeftSideNodes(root.left, count);
		 }
		 if(root.right!=null) {
			 findNumberOfRightSideNodes(root.right, count);
		 }
		 return count[0];
		
	}

	private static void findNumberOfLeftSideNodes(Node root, int[] count) {
		if(root==null) {
			return;
		}
		if(root!=null) {
			count[0]++;
		}
		if(root.left!=null) {
			findNumberOfLeftSideNodes(root.left, count);
		}
		else if(root.right!=null) {
			findNumberOfLeftSideNodes(root.right, count);
		}
		
	}
	
	private static void findNumberOfRightSideNodes(Node root, int[] count) {
		if(root==null) {
			return;
		}
		if(root!=null) {
			count[0]++;
		}
		if(root.right!=null) {
			findNumberOfRightSideNodes(root.right, count);
		}
		else if(root.left!=null) {
			findNumberOfRightSideNodes(root.left, count);
		}
		
	}

	static Node build_balanced_bst(int[] a) 
	    {
	        int mid=a.length/2;
	        
	        Node root = new Node(a[mid]);
	        root.left = constructTree(a, 0, mid-1);
	        root.right = constructTree(a, mid+1, a.length);
	        return root;
	        
	    }
	    
	    static Node constructTree(int[] a, int lowerIndex, int upperIndex) {
	    	System.out.println("the lower Index = " + lowerIndex + "  The upper Index  = " + upperIndex);
	        if(lowerIndex<0 || upperIndex>a.length || upperIndex<lowerIndex || lowerIndex>=a.length) { return null;}
	        int mid=lowerIndex + ((upperIndex-lowerIndex)/2);
	        System.out.println("Adding the root with index " + a[mid]);
        	Node root = new Node(a[mid]);
	        if(upperIndex==lowerIndex) {
	        	return root;
	        }
	        
	        root.left = constructTree(a, lowerIndex, mid-1);
	        root.right = constructTree(a,mid+1, upperIndex);
	        return root;
	    }
	
	 static int kth_smallest_element(Node root, int k) {
	        List<Node> nodeList = new ArrayList<Node>();
	        
	        populateList(root, k, nodeList);
	        return(nodeList.get(k-1).val);
	    }
	    
	    static void populateList(Node root, int k, List<Node> nodeList) {
	        if(root==null || k<=0) {
	            return;
	        }
	        populateList(root.left, k-1, nodeList);

	        nodeList.add(root);
	        populateList(root.right, k-1, nodeList);
	    }
	
	private static List<Node> getPath(Node root, Node destinationNode) {
		
		List<Node> pathList = new ArrayList<Node>();
		boolean[] found = new boolean[1];
		found[0]=false;
		
		populateList(root, destinationNode, pathList,found);
		
		printpathList(pathList);
		
		return pathList;
	}

	private static void populateList(Node root, Node destinationNode, List<Node> pathList, boolean[] found) {
		
		if(root==null || found[0]==true) {
			return;
		}
		pathList.add(root);
		
		if(destinationNode.val == root.val) {
			found[0]=true;
			return;
		}
		populateList(root.left, destinationNode, pathList, found);
		populateList(root.right, destinationNode, pathList, found);
		if(!found[0]) {
			pathList.remove(pathList.size()-1);
		}
		
		
	}

	public static void printAllPathFromRootToLeaf(Node root) {
		
		List<Node> path = new ArrayList<Node>();
		
		printPath(root, path);
	}

	private static void printPath(Node root, List<Node> path) {
		
		if(root==null) {
			return;
		}
		
		path.add(root);
		printPath(root.left, path);
		if(root.left==null && root.right == null) {
			printpathList(path);
		}
		printPath(root.right, path);
		path.remove(path.size()-1);
	}

	private static void printpathList(List<Node> path) {
		
		for(int i=0; i<path.size(); i++) {
			System.out.print(path.get(i).val + "    ");
		}
		System.out.println();
		
	}

}
