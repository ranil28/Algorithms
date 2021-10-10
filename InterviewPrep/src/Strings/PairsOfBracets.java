package Strings;
import java.util.*;

public class PairsOfBracets {
	
	public static void main(String[] args) {

	    String[] bracks = {"()", "(())", "(())", "()"};
	    int num = bracks.length;
	 
	    System.out.println(countPairs(bracks));
	}
	
	static int countPairs(String[] bracks) {
		
		Map<Integer, Integer> map = new HashMap<>();
		int pairs = 0;
		
		for (int i = 0; i < bracks.length; i++) {
			int count = getCount(bracks[i]);
			map.put(count, map.getOrDefault(count, 0) + 1);
		}
		
		Set<Integer> set = new HashSet<>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int key = entry.getKey();
			int value = entry.getValue();
			if (key == 0) {
				pairs += value/2;
				continue;
			}
			if (!set.contains(key)) {
				set.add(key);
				int reqVal = 0 - key;
				
				if (map.containsKey(reqVal) && !set.contains(reqVal)) {
					pairs += Math.min(map.get(reqVal), value);
					set.add(reqVal);
				}
			}
		}
		
		return pairs;
		
	}

	private static int getCount(String s) {
		int count = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				count++;
			}
			else {
				count--;
			}
		}
		return count;
	}

}
