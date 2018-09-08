
import java.util.ArrayList;
import java.util.List;

public class MySplit {
	//a method that split a string around a give regex (String)
	public static String[] mySplit(String str, String regex){

		List<String> result = new ArrayList<String>();
		int start = 0;
		int pos = str.indexOf(regex);
		while (pos >= start) {
			if (pos > start) {
				result.add(str.substring(start,pos));
			}
			start = pos + regex.length();
			pos = str.indexOf(regex,start); 
		}
		if (start < str.length()) {
			result.add(str.substring(start));
		}
		String[] array = result.toArray(new String[0]);
		return array;
	}

	public static void main(String[] args) {
		String str = "PeterHasABicycle";
		String regex = "Has";
		String[] arr = mySplit(str, regex);
		for(String s : arr) {
			System.out.println(s);
		}
		System.out.println("=========================");
		regex = "H";
		arr = mySplit(str, regex);
		for(String s : arr) {
			System.out.println(s);
		}
	}

}
