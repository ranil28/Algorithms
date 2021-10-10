package Greedy;

import java.util.HashSet;
import java.util.Set;

public class PrimsAlgo {
	public static void main(String[] args) {
	      int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
              { 2, 0, 3, 8, 5 },
              { 0, 3, 0, 0, 7 },
              { 6, 8, 0, 0, 9 },
              { 0, 5, 7, 9, 0 } };
              
              System.out.println(Prim(graph));
	}
	
	public static int[] Prim(int[][] adj) {
		int vertices = adj.length;
		int reqEdges = vertices - 1;
		
		int[] minDist = new int[vertices];
		boolean[] visited = new boolean[vertices];
		int[] parent = new int[vertices];
		
		for (int i = 0; i < vertices; i++) {
			minDist[i] = Integer.MAX_VALUE;
			visited[i] = false;
			parent[i] = -1;
		}
		
		minDist[0] = 0; // To consider as start Vertex and find the edge; 
		
		for (int i = 0; i < reqEdges; i++) {
			int currVertex = getMinVertex(minDist, visited);
			
			visited[currVertex] = true;
			
			for (int j = 0; j < vertices; j++) {
				if(adj[currVertex][j] != 0 && visited[j] == false && adj[currVertex][j] < minDist[j]) {
					minDist[j] = adj[currVertex][j];
					parent[j] = currVertex;
				}
			}
		}
		
		return parent;
	}

	private static int getMinVertex(int[] minDist, boolean[] visited) {
		int minVal = Integer.MAX_VALUE;
		int minIdx = -1;
		for (int i = 0; i < minDist.length; i++) {
			if (!visited[i] && minDist[i] < minVal) {
				minVal = minDist[i];
				minIdx = i;
			}
		}
		return minIdx;
	}

}
