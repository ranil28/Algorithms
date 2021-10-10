package Strings;

import java.util.*;


public class RemoveAtMostOne {
	static Map<Character, Character> map;
	
	
	private static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		
		
		for (int i = 0; i < s.length(); i++) {
			if (map.containsValue(s.charAt(i))) {
				stack.push(s.charAt(i));
			}
			else if (map.containsKey(s.charAt(i))) {
				if(stack.isEmpty()) {
					return false;
				}
				if (stack.peek() != map.get(s.charAt(i))) {
					return false;
				}
				stack.pop();
			}
		}
		
		return stack.isEmpty();
		
	}
	
	private static String removeInvalidPara(String s) {
		
		map = new HashMap<>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
		
		if(isValid(s)) {
			return s;
		}
		
//		Queue<String> queue = new LinkedList<>();
		
		
		for (int i = 0; i < s.length(); i++) {
			String str = s.substring(0, i) + s.substring(i + 1);
			
			if(isValid(str)) {
				return str;
			}
		}
		
		return "";
		
		
	}
	
	public static void main(String[] args) {
		System.out.println(removeInvalidPara("(({]}))"));
		System.out.println(removeInvalidPara("(({}))"));
		System.out.println(removeInvalidPara("(({})])"));
		System.out.println(removeInvalidPara("[(({}))"));
		System.out.println(removeInvalidPara("(({[}))"));
		System.out.println(removeInvalidPara("(({}))"));
		System.out.println(removeInvalidPara("(({})[)"));
		System.out.println(removeInvalidPara("[(({}))"));
	}

}
