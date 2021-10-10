package BackTrack;

import java.util.*;

public class NQueens {
	
	public static List<int[]> getPlacement(int n) {
		int[] rows = new int[n];
		int[] cols = new int[n];
		
		List<int[]> positions = new ArrayList<>();
		
		backTrack(rows, cols, positions);
		
		return positions;
		
	}
	
	
	public static boolean backTrack(int[] rows, int[] cols, List<int[]>positions) {
		
		if (positions.size() == rows.length) {
			return true;
		}
		
		for (int i = 0; i < rows.length; i++) {
			for (int j = 0; j < cols.length; j++) {
				int[] currPos = new int[] {i ,j};
				boolean flag = false;
				for (int k = 0;k < positions.size(); k++) {
					if(isConflict(positions.get(k), currPos, rows, cols)) {
						flag = true;
						break;
					}
				}
				
				if(!flag) {
					positions.add(currPos);
					rows[currPos[0]] = 1;
					cols[currPos[1]] = 1;
					if(backTrack(rows, cols, positions)) {
						return true;
					}
					rows[currPos[0]] = 0;
					cols[currPos[1]] = 0;
					positions.remove(positions.size() - 1);
				}
				
			}
		}
		
		return false;
	}


	private static boolean isConflict(int[] pos, int[] currPos, int[] rows, int[] cols) {
		if(rows[currPos[0]] == 1 || cols[currPos[1]] == 1 || 
				Math.abs(pos[0] - currPos[0]) == Math.abs(pos[1] - currPos[1])) {
			return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		List<int[]> lst = getPlacement(4);
		
		for (int i = 0; i < lst.size(); i++) {
			int[] val = lst.get(i);
			System.out.println(val[0] + " " + val[1]);
		}
	}

}
