package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
	Map<Integer, Node> mapping = new HashMap<Integer, Node>();
	int v;
	Node[] nodes;
	Graph(int v) {
		this.v = v;
		nodes = new Node[v];
		Node temp;
		for(int i=0; i<v; i++) {
			temp = new Node(i);
			mapping.put(i, temp);
			nodes[i] = temp;
		}
	}
	
	@Override
	public String toString() {
		StringBuffer output = new StringBuffer();
		output.append("[");
		for(int i=0; i<v; i++) {
			output.append(nodes[i].toString());
			output.append(", ");
		}
		output.append("]");
		
		return output.toString();
	}
	
	public void addEdge (int source, int destination) {
		Node sourceNode = mapping.get(source);
		Node destinationNode = mapping.get(destination);
		
		sourceNode.neighbors.add(destination);
		//destinationNode.neighbors.add(source);
	}

}

class Node {
	int id;
	List<Integer> neighbors;
	Node(int id) {
		this.id = id;
		neighbors = new ArrayList<Integer>();
	}
	@Override
	public String toString() {
		
		StringBuffer output = new StringBuffer();
		output.append("[");
		
		for(int i=0; i<neighbors.size(); i++) {
			output.append(neighbors.get(i));
			output.append(", ");
		}
		output.append("]");
		
		return output.toString();
		
		
	}
}
