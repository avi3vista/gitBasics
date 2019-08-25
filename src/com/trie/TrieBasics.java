package com.trie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieBasics {

	public static void main(String[] args) {
		Node root = new Node();
		String[] arr = { "video", "visual", "boat", "ball", "bat", "board" , "batter" };

		for (String s : arr) {
			insertIntoTrie(root, s);
		}

		System.out.println(root);
		System.out.println(isChildPresent(root, "bat"));

	}

	private static boolean isChildPresent(Node root, String string) {
		boolean isPresent = true;
		Node currentNode = root;
		for(char c : string.toCharArray()) {
			currentNode = getNodeIfPresent(currentNode, c);
			if(currentNode == null) {
				isPresent=false;
				break;
			}
		}
		
		return (currentNode!=null && currentNode.isEndAlso);
	}

	private static Node getNodeIfPresent(Node root, char c) {
		return root.getChildren().getOrDefault(c, null);
	}

	private static void insertIntoTrie(Node root, String s) {
		char[] charArr = s.toCharArray();
		Node currentNode = root;
		for (Character c : charArr) {
			currentNode = insertChild(c, currentNode);
		}
		currentNode.setEndAlso(true);

	}

	private static Node insertChild(Character c, Node currentNode) {
		if (!currentNode.getChildren().containsKey(c)) {
			currentNode.getChildren().put(c, new Node(c));
		}

		return currentNode.getChildren().get(c);
	}

	static class Node {
		char c;
		Map<Character, Node> children = new HashMap<Character, Node>();
		boolean isEndAlso;

		public Node(char c, Map<Character, Node> children, boolean isEndAlso) {
			super();
			this.c = c;
			this.children = children;
			this.isEndAlso = isEndAlso;
		}

		public Map<Character, Node> getChildren() {
			return children;
		}

		public void setChildren(Map<Character, Node> children) {
			this.children = children;
		}

		public boolean isEndAlso() {
			return isEndAlso;
		}

		public void setEndAlso(boolean isEndAlso) {
			this.isEndAlso = isEndAlso;
		}

		public char getC() {
			return c;
		}

		public void setC(char c) {
			this.c = c;
		}

		public Node() {
			super();
		}

		public Node(char c) {
			this.c = c;
			this.children = new HashMap<Character, Node>();
			this.isEndAlso = false;
		}

		public Node(char c, boolean isEndAlso) {
			this.c = c;
			this.children = new HashMap<Character, Node>();
			this.isEndAlso = isEndAlso;
		}
		
		@Override
		public String toString() {
			
			StringBuffer s = new StringBuffer();
			s.append("< value = " + this.c + "   ChildrenList = " +  this.children + "  Is End = " + this.isEndAlso + " >");
			return s.toString();
		}

	}

}
