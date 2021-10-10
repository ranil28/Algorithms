package Greedy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Graph implements Comparable<Graph>{
	int src;
	int dest;
	int cost;

	@Override
	public int compareTo(Graph o) {
		return this.cost - o.cost;
	}
}

class nodeFeature {
	int parent, rank;
}

public class KruskalsAlgo {
	
	public static void main(String[] args) {
		
		String[] str = new String[5];
		
		str[0] = "0 1 10";
		str[2] = "1 3 15";
		str[1] = "3 2 4";
		str[3] = "0 2 6";
		str[4] = "0 3 5";
		
		
		
		System.out.println(kruskalsApply(str));
		
		str[0] = "0 1 20";
		str[2] = "1 3 15";
		str[1] = "3 2 4";
		str[3] = "0 2 6";
		str[4] = "0 3 5";
		
		System.out.println(kruskalsApply(str));
		
	}
	

	
	

	
	static  nodeFeature[] feature;
	static int edgesNo;
	static int vertices;
	
	
	public static int getParent(int src) {
		
		if(feature[src].parent != src) {
			feature[src].parent = getParent(feature[src].parent);
		}
		
		return feature[src].parent;
		
	}
	
	
	
	public static int kruskalsApply(String[] str) {
		
		Graph[] graph = constructGraph(str);
		
		Arrays.sort(graph);
		
		int cost = 0;
		/* To ensure chosen edges don't exceed required num of edges*/
		int j = 0;
		for (int i = 0; i < graph.length&&j < edgesNo; i++) {
			Graph edge = graph[i];
			
			int x = getParent(edge.src);
			int y = getParent(edge.dest);
			
			/* There is already a connection bt x and y, adding this edge will form a cycle*/
			if (x == y) {
				continue;
			}
			
			union(x, y);
			j++;
			cost += edge.cost;
		}
		
		return cost;
		
		
		
	}
	
	/*
	 * Given the chosen edge, make one vertex a parent of the other. 
	 * If a chosen vertex has a some parent "x", then the new vertex's parent will also be "x".
	 */
	private static void union(int xroot, int yroot) {
		if (feature[xroot].rank
	            < feature[yroot].rank)
	            feature[xroot].parent = yroot;
	        else if (feature[xroot].rank
	                 > feature[yroot].rank)
	            feature[yroot].parent = xroot;
	 
	        // If ranks are same, then make one as
	        // root and increment its rank by one
	        else {
	            feature[yroot].parent = xroot;
	            feature[xroot].rank++;
	        }
	}



	private static Graph[] constructGraph(String[] str) {
		Graph[] edges = new Graph[str.length];
		
		/* needed to find num of unique vertices*/
		Set<Integer> set = new HashSet<>();
		
		/* Constructing graph with the edges*/
		for (int i = 0; i < str.length; i++) {
			String[] arr = str[i].split(" ");
			edges[i] = new Graph();
			
			
			edges[i].src = Integer.valueOf(arr[0]);
			edges[i].dest = Integer.valueOf(arr[1]);
			edges[i].cost = Integer.valueOf(arr[2]);
			
			set.add(edges[i].src);
			set.add(edges[i].dest);
			
		}
		
		vertices = set.size();
		edgesNo = vertices - 1;
		
		feature = new nodeFeature[vertices];
		
		for (int i = 0; i < vertices; i++) {
			feature[i] = new nodeFeature();
			
			feature[i].parent = i;
			feature[i].rank = 0;
		}
		
		return edges;
		
	}

}
