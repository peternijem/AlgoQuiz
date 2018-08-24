import java.util.Arrays;

/**
 * Given two strings, find if one of them is permutation of the other
 *
 */
public class IsPermutation {

	public static boolean isPermutation(String s1, String s2) {
		if(s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty()) {
			return false;
		}
		
		//Method #1
		char[] s1Arr = s1.toCharArray();
		char[] s2Arr = s2.toCharArray();
		Arrays.sort(s1Arr);
		Arrays.sort(s2Arr);
		return new String(s1Arr).equals(new String(s2Arr));
		
		//Method #2
//		Map<Character, Integer> map = new HashMap<>();
//		for(char c : s1.toCharArray()) {
//			Integer num = map.get(c);
//			if(num == null) {
//				map.put(c, 1);
//			}else {
//				map.put(c, num + 1);
//			}
//		}
//		for(char c : s2.toCharArray()) {
//			Integer num = map.get(c);
//			if(num == null) {
//				return false;
//			}else {
//				if(num - 1 == 0) {
//					map.remove(c);
//				}else {
//					map.put(c, num - 1);
//				}
//			}
//		}
//		return map.isEmpty();
		
		
	}
	
	public static void main(String[] args) {
		System.out.println(isPermutation("aab", "aba")); //true
		System.out.println(isPermutation("aasb", "aba")); //false
		System.out.println(isPermutation("aaaaaab", "aaabaa")); //false
		System.out.println(isPermutation("abc", "cba")); //true

	}

}
