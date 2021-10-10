package Others;

public class Gravity {
	
	public static void main(String[] args) {
		
		char[][] charVal = {
				{'F', 'F', 'F'},
				{'.', 'F', '.'},
				{'.', 'F', 'F'},
				{'#', 'F', '.'},
				{'F', 'F', '.'},
				{'.', '.', '.'},
				{'.', '.', '#'},
				{'.', '.', '.'},
		};
		
		gravity(charVal);
		
		for(int i = 0; i< charVal.length; i++) {
			for(int j = 0;j < charVal[0].length; j++) {
				System.out.print(charVal[i][j] + " ");
			}
			System.out.println("");
		}
		
	}
	
	public static char[][] gravity(char[][] charVal){
		boolean flag = false;
		
		while(true) {
			for (int i = 0; i < charVal[0].length; i++) {
				for (int j = charVal.length - 2; j >= 0; j--) {
					if (charVal[j][i] == 'F') {
						if(j == (charVal.length - 2) && charVal[j + 1][i] == '.') {
							flag = true;
						}
						else if(charVal[j + 1][i] == '.') {
							charVal[j + 1][i] = 'F';
							charVal[j][i] = '.';
							
							if (charVal[j + 2][i] == '#') {
								flag = true;
							}
							 
						}
					}
				}
			}
			
			if(flag) {
				break;
			}
			
		}
		

		return charVal;
		
		
	}

}
