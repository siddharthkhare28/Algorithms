package com.algos;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Graph {
	
	static HashMap<Integer, Vertice> verticeLookUp = new HashMap<Integer, Vertice>();

	static class Vertice{
		public Vertice(int id, List<Vertice> adjacent) {
			super();
			this.id = id;
			this.adjacent = adjacent;
		}
		public Vertice(){
			
		}
		int id;
		List<Vertice> adjacent = new LinkedList<Vertice>();
		boolean equals(Vertice v){
			return this.id == v.id;
		}
	}
	
	static Vertice getNode(int id){
		return verticeLookUp.get(id);
	}
	
	static void addEdge(Vertice source, Vertice destination){
		source.adjacent.add(destination);
		destination.adjacent.add(source);
	}
	
	static boolean hasPathDFS(Vertice source, Vertice destination){
		
		HashSet<Integer> visited = new HashSet<Integer>();
		return hasPathDFS(source, destination, visited);
	}
	
	static boolean hasPathDFS(Vertice source, Vertice destination, HashSet<Integer> visited){
		if (visited.contains(source.id)){
			return false;
		}
		visited.add(source.id);
		if (source.equals(destination)){
			return true;
		}
		source.adjacent.stream().forEach(vertice -> hasPathDFS(vertice, destination, visited));
		return false;
	}
	
	static boolean hasPathBFS(Vertice source, Vertice destination){
		Deque<Vertice> vertices = new ArrayDeque<Vertice>();
		HashSet<Integer> visited = new HashSet<Integer>();
		vertices.add(source);
		return hasPathBFS(source, destination, visited, vertices);
	}
	
	static boolean hasPathBFS(Vertice source, Vertice destination, HashSet<Integer> visited, Deque<Vertice> vertices){
		if(source.equals(destination)){
			return true;
		}
		if (!visited.contains(source.id)){
			visited .add(source.id);
			source.adjacent.stream().forEach(vertice -> vertices.add(vertice));
		}
		if(vertices.size()<1){
			return false;
		}else {
			hasPathBFS(vertices.pop(), destination, visited, vertices);
		}
		return false;
	}
	
	public static void main(String[] args){
		Vertice v1 = new Vertice(1, new LinkedList<Vertice>());
		Vertice v2 = new Vertice(1, new LinkedList<Vertice>());
		Vertice v3 = new Vertice(3, new LinkedList<Vertice>());
		
		v1.adjacent.add(v2);
		v2.adjacent.add(v1);
		
		verticeLookUp.put(1, v1);
		verticeLookUp.put(2, v2);
		verticeLookUp.put(3, v3);
		System.out.println(hasPathDFS(v1, v2));
		System.out.println(hasPathBFS(v1, v2));
		System.out.println(hasPathDFS(v1, v3));
		System.out.println(hasPathBFS(v1, v3));
	}
}
