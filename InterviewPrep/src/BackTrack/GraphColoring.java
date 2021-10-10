package BackTrack;

import java.util.*;

public class GraphColoring {
	
	public static Map<Integer, Integer> colorTheMap(boolean[][] graph, int numColors) {
		
		List<Integer> fullCombi = new ArrayList<>();
		
		return backTrack(graph, numColors, new HashMap<>());
		
		//return fullCombi;
	}

	private static Map<Integer, Integer> backTrack(boolean[][] graph, int numColors, Map<Integer, Integer>map) {
		
		if(map.size() ==graph.length) {
			return map;
		}
		
		
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < numColors; j++ ) {
				if(isValid(i, j, map, graph)) {
					map.put(i, j);
					Map<Integer, Integer> temp = backTrack(graph, numColors, map);
					if(temp != null) {
						return temp;
					}
					map.remove(j);
				}
				
			}
		}
		return null;
	}

	private static boolean isValid(int graphIdx, int colVal, Map<Integer, Integer> map, boolean[][] graph) {
		if(map.containsKey(graphIdx)) {
			return false;
		}
		for (int i = 0; i < graph.length; i++) {
			if(graph[graphIdx][i] == true) {
				//System.out.println(lst.size());
				if (map.getOrDefault(i, -1) == colVal) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
	    boolean[][] graph = {
	    	      { false, true, true, true },
	    	      { true, false, true, false },
	    	      { true, true, false, true },
	    	      { true, false, true, false },
	    	    };
	    int m = 3;
	    
	    Map<Integer, Integer> l = colorTheMap(graph, m);
	    

	    	for(int j = 0; j < l.size(); j++) {
	    		System.out.print(l.get(j) + " ");
	    	}

	    	    
	    	    
	    	 
	}

}
