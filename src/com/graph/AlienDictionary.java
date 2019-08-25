package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AlienDictionary {

	public static void main(String[] args) {
		
		String[] words = //{"wrt", "wrf", "er", "ett", "rftt"};
					 //{"abcd"};
			{"z","za"};
	//	String order = "abcdefghijklmnopqrstuvwxyz";
		
//		System.out.println(isAlienSorted(words, order));
		
		System.out.println("The order is " + getAlienOrder(words));

	}
	

	private static String getAlienOrder(String[] words) {
	StringBuffer order = new StringBuffer();
	CustomGraph graph = new CustomGraph();
	createVerticesAndNeighbors(graph,words);
	
	topologicalSort(graph, order);
	
	
	return order.toString();
	
	
	}
	
	private static void topologicalSort(CustomGraph graph, StringBuffer order) {
		
		Set<Character> visitedSet = new HashSet<Character>();
		Set<Character> pathSet = new HashSet<Character>();
		Boolean[] isCycle = {false};
		
		for(Vertex v : graph.vertices) {
			dfsSort(v, visitedSet, order, pathSet,isCycle);
		}
		
	}


	private static void dfsSort(Vertex vertex, Set<Character> visitedSet, StringBuffer order, Set<Character> pathSet, Boolean[] isCycle) {
		
		if(pathSet.size()>1 && pathSet.contains(vertex.c)) {
			order.setLength(0);
			isCycle[0]=true;
			return;
		}
		if(visitedSet.contains(vertex.c)) return;
		
		visitedSet.add(vertex.c);
		pathSet.add(vertex.c);
		
		for(Vertex v : vertex.neighbors) {
			dfsSort(v, visitedSet, order, pathSet,isCycle);
			if(isCycle[0]) {
				return;
			}
		}
		order.insert(0, vertex.c);
		pathSet.remove(vertex.c);
		
	}


	private static void createVerticesAndNeighbors(CustomGraph graph, String[] words) {
		Map<Character, Vertex> vertexMap = new HashMap<Character,Vertex>();
		if(words==null || words.length==0) {
			return;
		}
		String currentWord="";
		String nextWord = "";
		Character currentChar = ' ';
		Character nextChar = ' ';
		if(words.length==1) {
			int wordIndex =0;
			for(; wordIndex<words[0].length()-1; wordIndex++) {
				currentChar=words[0].charAt(wordIndex);
				nextChar=words[0].charAt(wordIndex);
				Vertex currentVertex = vertexMap.containsKey(currentChar) ? vertexMap.get(currentChar) : new Vertex(currentChar);
				vertexMap.put(currentChar, currentVertex);
				if(currentChar==nextChar) { continue; }
				
				Vertex neighborVertex = vertexMap.containsKey(nextChar) ? vertexMap.get(nextChar) : new Vertex(nextChar);
				currentVertex.neighbors.add(neighborVertex);
				vertexMap.put(currentChar, currentVertex);
				vertexMap.put(nextChar, neighborVertex);
			}
		}
		
		for(int i=0; i<words.length-1;i++) {
			currentWord = words[i];
			nextWord = words[i+1];
			for(int currentIndex=0; currentIndex<currentWord.length(); currentIndex++) {
				currentChar=currentWord.charAt(i);
				Vertex currentVertex = vertexMap.containsKey(currentChar) ? vertexMap.get(currentChar) : new Vertex(currentChar);
				vertexMap.put(currentChar, currentVertex);
				
				if(currentWord.length()>1) {
					nextChar=currentWord.charAt(i+1);
					
					Vertex neighborVertex = vertexMap.containsKey(nextChar) ? vertexMap.get(nextChar) : new Vertex(nextChar);
					currentVertex.neighbors.add(neighborVertex);
					vertexMap.put(currentChar, currentVertex);
					vertexMap.put(nextChar, neighborVertex);
				}
			}
			
			int diffIndex=0;
			for(; diffIndex<currentWord.length(); diffIndex++) {
				if(diffIndex>=nextWord.length()) {
					break;
				}
				currentChar = currentWord.charAt(diffIndex);
				nextChar = nextWord.charAt(diffIndex);
				if(currentChar!=nextChar) {
					Vertex currentVertex = vertexMap.containsKey(currentChar) ? vertexMap.get(currentChar) : new Vertex(currentChar);
					Vertex neighborVertex = vertexMap.containsKey(nextChar) ? vertexMap.get(nextChar) : new Vertex(nextChar);
					currentVertex.neighbors.add(neighborVertex);
					vertexMap.put(currentChar, currentVertex);
					vertexMap.put(nextChar, neighborVertex);
				}
			}
			diffIndex--;
			if(diffIndex<nextWord.length()) {
				currentChar=nextWord.charAt(diffIndex);
				for(;diffIndex<nextWord.length()-1; diffIndex++) {
					currentChar = nextWord.charAt(diffIndex);
					nextChar = nextWord.charAt(diffIndex+1);
					if(currentChar!=nextChar) {
						Vertex currentVertex = vertexMap.containsKey(currentChar) ? vertexMap.get(currentChar) : new Vertex(currentChar);
						Vertex neighborVertex = vertexMap.containsKey(nextChar) ? vertexMap.get(nextChar) : new Vertex(nextChar);
						currentVertex.neighbors.add(neighborVertex);
						vertexMap.put(currentChar, currentVertex);
						vertexMap.put(nextChar, neighborVertex);
					}
				}
			}
			
		}
		
		for(Character c : vertexMap.keySet()) {
			graph.vertices.add(vertexMap.get(c));
		}
		
		
	}

	static class CustomGraph{
		List<Vertex> vertices = new ArrayList<Vertex>();
		
		CustomGraph(List<Vertex> vertices) {
			this.vertices = vertices;
		}
		
		CustomGraph() {
			super();
		}
	}
	
	static class Vertex {
		Character c;
		List<Vertex> neighbors;
		Vertex(Character c) {
			this.c = c;
			neighbors = new ArrayList<Vertex>();
		}
	}

public static boolean isAlienSorted(String[] words, String order) {
        boolean isSorted = true;
        if(words==null || words.length==0 || order==null) {
        	return !isSorted;
        }
        char currentChar = ' ';
    	char nextChar = ' ';
        if(words.length==1) {
        	String currentWord = words[0];
        	
        	for(int i=0; i<words[0].length()-1; i++) {
        		currentChar = currentWord.charAt(i);
        		nextChar = currentWord.charAt(i+1);
        		if(order.charAt(currentChar)>order.charAt(currentChar)) {
        			isSorted=false;
        			break;
        		}
        	}
        	return isSorted;
        }
        String currentWord = "";
        String nextWord = "";
        
        for(int i=0; i<words.length-1; i++) {
        	currentWord = words[i];
        	nextWord = words[i+1];
        	boolean found=false;
        	int diffIndex=0;
        	for(; diffIndex<currentWord.length(); diffIndex++) {
        		if(diffIndex>=nextWord.length()) {
        			return false;
        		}
        		if(currentWord.charAt(diffIndex)!=nextWord.charAt(diffIndex)) {
        			found=true;
        			break;
        		}
        		
        	}
        	if(found) {
    			currentChar = currentWord.charAt(diffIndex);
    			nextChar = nextWord.charAt(diffIndex);
    		}
        	if(order.indexOf(currentChar)>order.indexOf(nextChar)) {
    			isSorted=false;
    			return isSorted;
    		}
        }
        
        
        return isSorted;
    }

}
