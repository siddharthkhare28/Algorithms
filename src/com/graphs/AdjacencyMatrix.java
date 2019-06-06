package com.graphs;

import java.util.HashSet;

public class AdjacencyMatrix {
	
	static class Vertice{
		public Vertice(int id) {
			super();
			this.id = id;
		}
		public Vertice(){
			
		}
		int id;
		boolean equals(Vertice v){
			return this.id == v.id;
		}
	}
	
	static int maxCapacity = 20;
	static int[][] adjMatrix = new int[maxCapacity][maxCapacity];
	static Vertice[] vertices = new Vertice[maxCapacity];
	private static int nVerts = 0;
	
	{
		for (int i=0; i<maxCapacity; i++){
			for (int j=0; j<maxCapacity; j++){
				adjMatrix[i][j] = 0;
			}
		}
	}
	
	public static void addVertex(Vertice v){
		vertices[nVerts++] = v;
	}
	
	public void addEdge(int start, int end){
		adjMatrix[start][end] = 1;
		adjMatrix[end][start] = 1;
	}

	static boolean dfs(Vertice start, Vertice end){
		HashSet<Vertice> visited = new HashSet<Vertice>();
		return dfs(start, end, visited);
	}
	
	static boolean dfs(Vertice start, Vertice end, HashSet<Vertice> visited){
//		if(visited.contains(start)){
//			return false;
//		}
		visited.add(start);
		if(start.equals(end)){
			return true;
		}
		int[] child = adjMatrix[start.id-1];
		for(int i=0; i<maxCapacity; i++){
			if(child[i] == 1){
				if(!visited.contains(vertices[i])){
					return dfs(vertices[i], end, visited);
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args){
		Vertice v1 = new Vertice(1); 
		Vertice v2 = new Vertice(2); 
		Vertice v3 = new Vertice(3); 
		
		adjMatrix[v1.id-1][v2.id-1] = 1;
		adjMatrix[v2.id-1][v1.id-1] = 1;
		vertices[0] = v1;
		vertices[1] = v2;
		vertices[2] = v3;
		System.out.println(dfs(v1, v2));
		System.out.println(dfs(v1, v3));
	}
	
}
