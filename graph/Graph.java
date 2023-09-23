package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Graph {
	private static Map<Integer, List<Integer>> adj;
	
	public Graph(int size) {
		adj = new HashMap<>();			
	}
	
	public void addEdge(int v1, int v2){
		if(adj.containsKey(v1)) {
			List<Integer> neighbor = adj.get(v1);
			neighbor.add(v2);
		}
		else {
			adj.put(v1, new ArrayList<Integer>());
			List<Integer> neighbor = adj.get(v1);
			neighbor.add(v2);
		}
	}
	
	public static List<Integer> bfsHelper(Map<Integer,List<Integer>> adj, int v, List<Integer> bfsResult, boolean[] isVisited){
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(v);
		isVisited[v] = true;
		
		while(!q.isEmpty()) {
			int curV = q.poll();
			bfsResult.add(curV);
			
			List<Integer> neighbors = adj.get(curV);
			
			if(neighbors != null) {
			for(int neighbor : neighbors) {
				if(!isVisited[neighbor]) {
					q.offer(neighbor);
					isVisited[neighbor]=true;
				}
			}
			}
		}
		
		
		return bfsResult;
	}
	
	public static void main(String[] args) {
		Graph graph = new Graph(7);
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 4);
		graph.addEdge(1, 3);
		graph.addEdge(4, 6);
		graph.addEdge(3, 5);
		graph.addEdge(5, 6);
		graph.addEdge(2, 6);
		
		List<Integer> bfsResult = new ArrayList<Integer>();
		
		boolean[] isVisited = new boolean[7];
		
		bfsResult = bfsHelper(adj, 0, bfsResult, isVisited);
		
		System.out.println(bfsResult);
	}
}
