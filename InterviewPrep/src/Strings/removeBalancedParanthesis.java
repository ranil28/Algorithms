package Strings;
import java.util.*;

public class removeBalancedParanthesis {
	
	static void cntBalancedParenthesis(String s) {
		
		Map<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
		
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				String neg = String.valueOf(map.get(s.charAt(i)));
				
				String sub = s.substring(i);
				
				if (sub.contains(neg)) {
					int idx = s.lastIndexOf(neg);
					s = s.substring(0, idx) + s.substring(idx + 1);
					s = s.substring(0, i) + s.substring(i + 1);
					
					
				}
			}
		}
		System.out.println(s);
	}
	
	
	public static void main(String[] args) {
		cntBalancedParenthesis("{(}]");
		cntBalancedParenthesis(")}(}");
		cntBalancedParenthesis("[{(}]");
		cntBalancedParenthesis(")}({{}");
	}

}
