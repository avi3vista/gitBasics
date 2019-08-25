package com.dataStructures;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

	private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; // Adjacency List Represntation
 
    // Constructor
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for(int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
 
    // Function to add an edge into the graph
    void addEdge(int v,int w) {
        adj[v].add(w);
        adj[w].add(v);
    }
    
    
    public static void main(String args[])
    {
    	Graph g = new Graph(4);
    	 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        System.out.println("print BFS");
        printBFS(g,2);
        
    }

	private static void printBFS(Graph g, int startPoint) {
		
		
		Queue<Integer> visitQueue = new LinkedList<Integer>();
		boolean[] visitList = new boolean[4];
		
		visitQueue.add(startPoint);
		while(!visitQueue.isEmpty()) {
			int vertex = visitQueue.poll();
			
			if(!visitList[vertex]) {
				visitList[vertex] = true;
				System.out.println("visiting " + vertex);
				Iterator i = g.adj[vertex].iterator();
				while (i.hasNext()) {
					visitQueue.add((Integer) i.next());
				}
			}
		}
	}
	
}
