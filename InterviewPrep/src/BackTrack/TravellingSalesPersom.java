package BackTrack;

import java.util.ArrayList;
import java.util.List;

/*
 * Starts from a city, visits all other cities and returns to the same city.
 */
public class TravellingSalesPersom {
	
	static int min = Integer.MAX_VALUE;
	
	public static int getMinDist(int[][] cost) {
		
		getMin(0, 0, new ArrayList<>(), cost, 0);
		
		return min;
	}
	
	
	public static void getMin(int startIdx, int currIdx, List<Integer> visited, int[][] cost, int currCost) {
		
		if (visited.size() == cost.length) {
			min = Math.min(currCost + cost[currIdx][startIdx], min);
			return;
		}
		
		for (int i = 0; i < cost.length; i++) {
			if(!visited.contains(i)) {
				visited.add(i);
				getMin(startIdx, i, visited, cost, currCost + cost[currIdx][i]);
				visited.remove(visited.size() - 1);
			}
		}
		
	}
	
	public static void main(String[] args) {

        int[][] graph = {{0, 10, 15, 20},
                         {10, 0, 35, 25},
                         {15, 35, 0, 30},
                         {20, 25, 30, 0}};
        
        System.out.println(getMinDist(graph));
	}
	
	

}
