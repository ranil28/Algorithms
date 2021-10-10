package Strings;
import java.util.*;

public class balanceByOneShift {
	
	public static void main(String[] args) {
		System.out.println(canBeBalanced("()()())(()"));
	}
	
	static boolean canBeBalanced(String s) {
		
		Stack<Character> stack = new Stack<>();
		int idx = -1;
		
		
		for (int i = 0; i < s.length(); i++) {
			
			if (s.charAt(i) == '(' ) {
				stack.push(s.charAt(i));
			}
			else {
				if (stack.size() == 0) {
					s = s.substring(0, i) + s.substring(i + 1);
					break;
				}
				else {
					idx = i + 1;
					stack.pop();
				}
			}
			
		}
		
//		System.out.println(s);
		for (int i = 0; i <= s.length(); i++) {
			String str =  s.substring(0, i) + ')' +s.substring(i);
			System.out.println(str);
			if (isValid(str)) {
				return true;
			}
		}
		
		return false;
		
	}
	
	static private boolean isValid(String s) {
		int count = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				count++;
			}
			else if (s.charAt(i) == ')') {
				count--;
			}
			
			if(count < 0) {
				return false;
			}
			
		}
		
		return count == 0;
	}

}
