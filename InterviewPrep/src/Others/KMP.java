package Others;

import java.util.*;

class KMP {

  
    // Driver program to test above function
    public static void main(String args[])
    {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        KMPSearch(pat, txt);
    }

	private static void KMPSearch(String pat, String txt) {
		

		
		
		// Generate Pi table
		
		int[] piTable = new int[pat.length() + 1];
		char[] charTable = new char[pat.length() + 1];
		
		int start = 0;
		//int curr = 0;
		charTable[1] = pat.charAt(0);
		for (int i = 1; i < pat.length(); i++) {
			if(pat.charAt(i) == pat.charAt(start)) {
				piTable[i+1] = start;
				start++;
			}
			else {
				start = 0;
			}
			charTable[i + 1] = pat.charAt(i);
		}
		
		// Traverse through array
		
		int idx = 0;
		
		int i = 0;
		
		for (i = 0; i < txt.length(); i++) {
			if (charTable[idx + 1] == txt.charAt(i)) {
				idx++;
			}
			else {
				idx = piTable[idx];
			}
			
			if (idx == (pat.length() - 1)) {
				i++;
				break;
			}
		}
		
		if (idx == (pat.length() - 1)) {
			System.out.println("Found at index " + (i - pat.length() + 1));
		}
		else {
			System.out.println("Not found");
		}
		
		
		
		
		
		
	}
}