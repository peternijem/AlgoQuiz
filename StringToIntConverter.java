
import org.junit.Assert;

public class StringToIntConverter {

	public static void main(String[] args) {
		
		final String inputNum = "4321";
		int res = stringToInt(inputNum);
		Assert.assertEquals(Integer.parseInt(inputNum), res );
		
		final String invalidInputNum = "123a";
		res = stringToInt(invalidInputNum);
		Assert.assertEquals(-1, res );
		
		final String negativeInputNum = "-123";
		res = stringToInt(negativeInputNum);
		Assert.assertEquals(Integer.parseInt(negativeInputNum), res );

	}
	
	public static int stringToInt(String num) {
		if(num == null || num.isEmpty()) {
			return -1;
		}
		
		boolean isNegative = false;
		int result = 0;
		char[] chars = num.toCharArray();
		
		int j=0;
		if(chars[0] == '-') {
			j++;
			isNegative = true;
		}
		
		int factorial = (int)Math.pow(10, (num.length() - 1) - j);
		for(int i=j; i < chars.length; i++) {
			
			if(chars[i] - '0' < 0 || '9' - chars[i] < 0) {
				return -1; //illegal character
			}
			
			result+=(chars[i] - '0') * factorial;
			factorial = factorial / 10;
		}
		
		
		if(isNegative) {
			return result * -1;
		}
		return result;
	}

}
