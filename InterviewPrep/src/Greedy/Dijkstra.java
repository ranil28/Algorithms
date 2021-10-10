package Greedy;

public class Dijkstra {
	
	public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
            { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
            { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
            { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
            { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
            { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
            { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
            { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
            { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
            System.out.println(getShortestPath(graph, 0, 5));
	}
	
	
	
	public static int getShortestPath(int[][] graph, int v1, int v2) {
		int vertices = graph.length;
		boolean[] visited = new boolean[vertices];
		int[] minDist = new int[vertices];
		int[] parent = new int[vertices];
		
		for (int i = 0; i < vertices; i++) {
			visited[i] = false;
			minDist[i] = Integer.MAX_VALUE;
			parent[i] = -1;
		}
		
		minDist[v1] = 0;		
		
		while(visited[v2] == false) {
			int currIdx = getIdx(minDist, visited);
			visited[currIdx] = true;
			for (int i = 0; i < vertices; i++) {
				if(graph[currIdx][i] != 0 && (graph[currIdx][i] + minDist[currIdx]) < minDist[i] && visited[i] == false) {
					minDist[i] = graph[currIdx][i] + minDist[currIdx];
				}
			}
		}
		
		return minDist[v2];
		
	}

	private static int getIdx(int[] minDist, boolean[] visited) {
		int minVal = Integer.MAX_VALUE;
		int minIdx = 0;
		for (int i = 0; i < minDist.length; i++) {
			if (visited[i] == false && minVal > minDist[i]) {
				minVal = minDist[i];
				minIdx = i;
			}
		}
		
		return minIdx;
	}

}
