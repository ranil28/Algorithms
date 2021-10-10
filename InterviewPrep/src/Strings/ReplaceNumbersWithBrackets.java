package Strings;

public class ReplaceNumbersWithBrackets {
	
	private static boolean canBeConverted(String s) {
		if (s.charAt(0) == s.charAt(s.length() - 1)) {
			return false;
		}
		
		int start = 0;
		int end = s.length() - 1;
		
		while ((start <= end) && (s.charAt(end) != s.charAt(start))) {
//			System.out.println(s);
			s = s.replace(s.charAt(start), '(');
			s = s.replace(s.charAt(end), ')');
			
			while ((start < s.length())) {
				if ((s.charAt(start) == '(' || s.charAt(start) == ')')) {
					start++;
				}
				else {
					break;
				}
				
			}
			
			while ((end > 0)) {
				if((s.charAt(end) == '(' || s.charAt(end) == ')')) {
					end--;
				}
				else {
					break;
				}
				
			}
//			System.out.println(end);
//			System.out.println(start);
//			System.out.println(s);
		}
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			
			if (s.charAt(i) == '(') {
				count++;
			}
			else {
				count--;
			}
			
			if (count < 0) {
				return false;
			}
			
		}
		
		System.out.println(s);
		
		return count == 0;
	}
	
	public static void main(String[] args) {
//		System.out.println(canBeConverted("1122"));
//		System.out.println(canBeConverted("1121"));
//		System.out.println(canBeConverted("123122"));
		System.out.println(canBeConverted("1233334442"));
	}

}
