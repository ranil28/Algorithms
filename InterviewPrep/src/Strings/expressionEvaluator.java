package Strings;

public class expressionEvaluator {
	
	public static void main(String[] args) {
		System.out.println(eval("5+6-7*8"));
		System.out.println(eval("5"));
		System.out.println(eval("5--"));
	}
	
	static double eval(String s) {
		
		int leftVal = 0;
		
		if(Character.isDigit(s.charAt(0))) {
			leftVal = Character.getNumericValue(s.charAt(0));
		}
		else {
			return -1;
		}
		
		
		for (int i = 1; i < s.length(); i = i + 2) {
			
			int rightVal;
			
			if(Character.isDigit(s.charAt(i + 1))) {
				rightVal = Character.getNumericValue(s.charAt(i + 1));
			}
			else {
				return -1;
			}

				
			switch (s.charAt(i)) {
				case '+':
					leftVal += rightVal;
					break;
					//System.out.println(leftVal);
				case '-':
					leftVal = leftVal - rightVal;
					break;
				case '*':
					leftVal = leftVal * rightVal;
					break;
				case '/':
					leftVal = leftVal / rightVal;
					break;
				default :
					return -1;
				
			}

		}
		
		return leftVal;
		
	}

}
