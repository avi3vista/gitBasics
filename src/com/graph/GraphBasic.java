package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GraphBasic {

	public static void main(String[] args) {
		
		Graph graph = new Graph(3);

		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		/*graph.addEdge(2, 4);
		graph.addEdge(3, 5);
		graph.addEdge(4, 5);
		graph.addEdge(5, 6);
		graph.addEdge(6, 7);
		graph.addEdge(5, 8);
		graph.addEdge(8, 9);
		graph.addEdge(9, 10);
		graph.addEdge(10, 7);*/
		Map<Integer, List<Integer>> backRefs = new HashMap<Integer, List<Integer>>();
		//BFS(graph, 0, new HashSet<Integer>(),backRefs);
		
		//System.out.println(backRefs);
		System.out.println(reverseGraph(graph, graph.nodes[0]));
		
		System.out.println("");


	}
	
	public static void BFS(Graph graph, int start, Set<Integer> visited, Map<Integer, List<Integer>> backRefs) {
		Node startNode = graph.nodes[start];
		Queue<Node> q = new LinkedList<Node>();
		
		q.add(startNode);
		while(!q.isEmpty()) {

			Node currentNode = q.poll();
			System.out.println("Printing current Node : " + currentNode.id);
			if(visited.contains(currentNode.id)) continue;
			visited.add(currentNode.id);
			for(int i : currentNode.neighbors) {
				q.add(graph.nodes[i]);
				if(backRefs.containsKey(graph.nodes[i].id)) {
					backRefs.get(graph.nodes[i].id).add(currentNode.id);
				}
				else {
					List<Integer> tempList = new ArrayList<Integer>();
					tempList.add(currentNode.id);
					backRefs.put(graph.nodes[i].id, tempList);
				}
			}
		}
	}
	
	
	public static Node reverseGraph(Graph graph, Node node) {
		
		
		
		Map<Integer, Node> newGraph = new HashMap<Integer, Node>();
		
		Node newNode = reverseGraphBFS(graph, node, new HashSet<Integer>(), new HashMap<Integer, Node>());
		
		return newNode;
	}
	
	public static Node reverseGraphBFS(Graph graph, Node node, Set<Integer> visitedSet, Map<Integer, Node> newGraph) {
		Node newNode = new Node(node.id);
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		while (!q.isEmpty()) {
			Node currentNode = q.poll();
			if(visitedSet.contains(currentNode.id)) {
				continue;
			}
			visitedSet.add(currentNode.id);
			for(int i=0; i<currentNode.neighbors.size(); i++) {
				int nodeval = currentNode.neighbors.get(i);
				if(newGraph.containsKey(currentNode.neighbors.get(i))) {
					newGraph.get(currentNode.neighbors.get(i)).neighbors.add(i);
				}
				else {
					Node tempNode = new Node(currentNode.neighbors.get(i));
					List<Integer> mapping = new ArrayList<Integer>();
					mapping.add(i);
					tempNode.neighbors = mapping;
					newGraph.put(i, tempNode);
				}
				q.add(graph.nodes[currentNode.neighbors.get(i)-1]);
			}
			
		}
		return newGraph.get(node.id);
	}

}
