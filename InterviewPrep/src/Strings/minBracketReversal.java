package Strings;
import java.util.*;

public class minBracketReversal {
	
	public static void main(String[] args) {
	    String expr ="}{";
	    
	    System.out.println("//" + countMinReversals(expr));
	}
	
	
	static int countMinReversals(String expr) {
		char[]  arr = expr.toCharArray();
		int count = 0;
		
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < arr.length; i++) {
			
			if (arr[i] == '}') {
				if(!stack.isEmpty()) {
					stack.pop();
				}
				else {
					count++;
					stack.push('{');
				}
			}
			else {
				stack.push(arr[i]);
			}
			
		}
		
		while (stack.size() > 1) {
			stack.pop();
			stack.pop();
			count++;
		}
		
		return count;
	}

}
