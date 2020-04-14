package mcdowell;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements linear search of a string in a given string 
 * using Rabin Karp's search and Rolling hash function 
 * 
 */
public class LinearSearch {
	
	static void search(String s, String b) {
		int lenofS = s.length();
		int lenofB = b.length();
		List<Integer> posMatches = new ArrayList<>();
		int prevHash = 0;
		int sHash = hash(s);
		
		for(int i=0;i<(lenofB-lenofS);i++) {
			int posMatchHash=0;
			if(prevHash>0) {
				
				// implementing rolling hash to save calls to hash() for every substring
				// str='abcd'
				// hash ('bcd') = (hash('abc')-ascii(a)*128^2)*128 + ascii(d)
				
				int prevChar = b.charAt(i-1);
				int nextChar = b.charAt(i+lenofS-1);
				
				posMatchHash = (int) (prevHash-(prevChar*Math.pow(128,lenofS-1)))*128 + nextChar;
			
			}else {
				
				String subStr = b.substring(i, i+lenofS);
				posMatchHash=hash(subStr);				
				
			}
			
			if(posMatchHash==sHash)
				posMatches.add(i);
			
			prevHash=posMatchHash;
		}		
		
		// check for all possible matches
		for(int index : posMatches) {
			String str1 = b.substring(index,index+lenofS);
			if(s.equals(str1))
				System.out.println(index);
		}
	}
	
	/**
	 * Return hash of a string
	 * str = abc
	 * hash(str) = ascii(a)*128^2 + ascii(b)*128^1 + ascii(c)*128^0
	 * @param str
	 * @return
	 */
	static int hash(String str) {
		int hash=0;
		char[] charsInStr = str.toCharArray();
		for(int i =0;i<str.length();i++) {
			
			int charValue = charsInStr[i];
			hash+=charValue*Math.pow(128, str.length()-1-i);
		}
		return hash;
	}
	
	public static void main(String[] args) {
		System.out.println("Possible matches at Index: ");
		search("anki","anki anki ank ai ankit anki ankita a ");
	}

}
