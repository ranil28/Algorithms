package Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Stripe {
    public static void main(String[] args) {
        String charge = "[\"CHARGE:card_country=US&currency=USD&amount=2500&ip_country=CA\",\"ALLOW:amount>500ANDip_country==CA\",\"BLOCK:card_country==CAORcard_country==MA\",  ]\n";
        String charge1 = "[\"CHARGE:card_country=US&currency=USD&amount=2500&ip_country=CA\",\"ALLOW:amount>500ANDip_country==CA\",\"BLOCK:card_country==USANDamount<200\",  ]\n";
        String charge2 = "[\"CHARGE:card_country=US&currency=USD&amount=2500&ip_country=CA\",\"ALLOW:currency==EUR\",  ]\n";
        String charge3 = "[\"CHARGE:card_country=US&currency=USD&amount=2500&ip_country=CA\",\"BLOCK:amount>500\",  ]\n";

        System.out.println(isAllowed(charge));
        System.out.println(isAllowed(charge1));
        System.out.println(isAllowed(charge2));
        System.out.println(isAllowed(charge3));

    }

	private static boolean isAllowed(String charge) {
		Pattern pattern = Pattern.compile
				("CHARGE:card_country=(.*?)&currency=(.*?)&amount=(.*?)&ip_country=(.*?)\"");
		Matcher match = pattern.matcher(charge);
		
		if(match.find()) {
			String country = (match.group(1));
			String currency = match.group(2);
			int amount = Integer.valueOf(match.group(3));
			String ip = (match.group(4));
			
			
			//Process allowed
			pattern = Pattern.compile
					("ALLOW:(.*?)\",");
			match = pattern.matcher(charge);
			boolean isAllow = true;
			

			
			if(match.find()) {
				String m = match.group(1);
				String[] operations = m.split("(AND)|(OR)");
				
				 {
					pattern = Pattern.compile("(.*?)([>=!<]+)(.*?)$");
					match = pattern.matcher(operations[0]);
					
					if(match.find()) {
						String entity = match.group(1);
						String cmp = match.group(2);// + match.group(3);
						String val = match.group(3);
						
						if(entity.equals("card_country")) {
							isAllow = strMatch(country, val, cmp);
						}
						else if(entity.equals("currency")) {
							isAllow = strMatch(currency, val, cmp);
						}
						else if (entity.equals("amount")) {
							isAllow = intMatch(amount, val, cmp);
						}
						else {
							isAllow = strMatch(ip, val, cmp);
						}
 						//String a = mat.group(1);
						
						if(m.contains("OR") || m.contains("AND")) {
							pattern = Pattern.compile("(.*?)([>=!<]+)(.*?)$");
							match = pattern.matcher(operations[1]);
							if(match.find()) {
								entity = match.group(1);
								cmp = match.group(2);
								val = match.group(3);
								boolean al = isAllow;
								if(entity.equals("card_country")) {
									isAllow = strMatch(country, val, cmp);
								}
								else if(entity.equals("currency")) {
									isAllow = strMatch(currency, val, cmp);
								}
								else if (entity.equals("amount")) {
									isAllow = intMatch(amount, val, cmp);
								}
								else {
									isAllow = strMatch(ip, val, cmp);
								}
								if(m.contains("OR")) {
									isAllow = isAllow | al;
								}
								else {
									isAllow = isAllow & al;
								}
							}

						}
					}
				 }
				
				
			}
				 
				 if(!isAllow) {
					 return false;
				 }
				isAllow = true;
				
				//Process not allowed
				pattern = Pattern.compile
						("BLOCK:(.*?)\",");
				match = pattern.matcher(charge);
				

				
				if(match.find()) {
					String m = match.group(1);
					String[] operations = m.split("(AND)|(OR)");
					
					 {
						pattern = Pattern.compile("(.*?)([>=!<]+)(.*?)$");
						match = pattern.matcher(operations[0]);
						
						if(match.find()) {
							String entity = match.group(1);
							String cmp = match.group(2);
							String val = match.group(3);
							
							if(entity.equals("card_country")) {
								isAllow = !strMatch(country, val, cmp);
							}
							else if(entity.equals("currency")) {
								isAllow = !strMatch(currency, val, cmp);
							}
							else if (entity.equals("amount")) {
								isAllow = !intMatch(amount, val, cmp);
							}
							else {
								isAllow = !strMatch(ip, val, cmp);
							}
	 						//String a = mat.group(1);
							
							if(m.contains("OR") || m.contains("AND")) {
								pattern = Pattern.compile("(.*?)([>=!<]+)(.*?)$");
								match = pattern.matcher(operations[1]);
								if(match.find()) {
									entity = match.group(1);
									cmp = match.group(2);
									val = match.group(3);
									boolean al = isAllow;
									if(entity.equals("card_country")) {
										isAllow = !strMatch(country, val, cmp);
									}
									else if(entity.equals("currency")) {
										isAllow = !strMatch(currency, val, cmp);
									}
									else if (entity.equals("amount")) {
										isAllow = !intMatch(amount, val, cmp);
									}
									else {
										isAllow = !strMatch(ip, val, cmp);
									}
									if(m.contains("OR")) {
										isAllow = isAllow | al;
									}
									else {
										isAllow = isAllow & al;
									}
								}

							}
						}
					 }
					
					
				}			
			

			
			return isAllow;
		}
		return false;		
	}
	
	private static boolean intMatch(int amount, String val, String cmp) {
		Map<String, Integer> allowedOper = new HashMap<>();
		allowedOper.put(">",0);
		allowedOper.put(">=",1);
		allowedOper.put("<",2);
		allowedOper.put("<=",3);
		allowedOper.put("==",4);
		allowedOper.put("!=",5);
		
		int valueInInt = Integer.valueOf(val);
		
		int oper= allowedOper.get(cmp);
		
		if(oper == 0) {
			return amount > valueInInt;
		}
		else if(oper == 1) {
			return amount >= valueInInt;
		}
		else if(oper == 2) {
			return amount < valueInInt;
		}
		else if(oper == 3) {
			return amount <= valueInInt;
		}
		else if(oper == 4) {
			return amount == valueInInt;
		}
		else if(oper == 5) {
			return amount != valueInInt;
		}
		
		return false;
	}

	static boolean strMatch(String a, String b, String oper) {
		Map<String, Integer> allowedOper = new HashMap<>();
		allowedOper.put("==",4);
		allowedOper.put("!=",5);
		
		if(allowedOper.get(oper) == 4) {
			return a.equals(b);
		}
		return !a.equals(b);
		
	}

}
