package Strings;

import java.util.*;

public class BalancedBracketsWithReplacement {
	static Map<Character, Character> map;
	
	private static String getBalanced(String s) {

		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			if (map.containsValue(s.charAt(i))) {
				stack.push(s.charAt(i));
			}
			else if (map.containsKey(s.charAt(i))) {
				if (stack.isEmpty()) {
					return "";
				}
				
				if (stack.peek() != s.charAt(i)) {
					return "";
				}
				stack.pop();
			}
			else {
				char[] arr = s.toCharArray();
				if (i != s.length()) {
					Character t = arr[i];
					arr[i] = map.get(arr[i + 1]);
					
					String temp = getBalanced(arr.toString());
					
					if (!temp.equals("")) {
						return temp;
					}
					arr[i] = t;
					
				}
				
//				if (stack.size() > 0) {
//					Character t = arr[i];
//					//arr[i] = 
//				}
			}
		}
		
		
		return s;
		
		
	}
	
	public static void main(String[] args) {
		
		map = new HashMap<>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
		
	}

}
