

import java.util.HashSet;
import java.util.Set;

/**
 * Java Program to find all permutations of a String
 *
 */
public class StringFindAllPermutations {
	public static Set<String> permutationFinder(String str) {
		Set<String> perm = new HashSet<String>();
		//Handling error scenarios
		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			perm.add("");
			return perm;
		}
		char initial = str.charAt(0); // first character
		String rem = str.substring(1); // Full string without first character
		Set<String> words = permutationFinder(rem);
		for (String strNew : words) { 
			for (int i = 0;i <= strNew.length();i++){
				String begin = strNew.substring(0, i);
				String end = strNew.substring(i);
				perm.add(begin + initial + end);
			}
		}
		return perm;
	}


	public static void main(String[] args) {
		// String s = "AAC";
		//String s1 = "ABC";
		 	String s2 = "ABCD";
		 //System.out.println("\nPermutations for " + s + " are: \n" + permutationFinder(s));
		//System.out.println("\nPermutations for " + s1 + " are: \n" + permutationFinder(s1));
		System.out.println("\nPermutations for " + s2 + " are: \n" + permutationFinder(s2));


	}
}
