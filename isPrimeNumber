public class isPrimeNumber {

	// function check whether a number 
	// is prime or not
	static boolean isPrime(int n) {
		// Corner case
		if (n <= 1) {
			return false;
		}

		// Check from 2 to n-1
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}

		//  Consider that if 2 divides some integer n, then (n/2) divides n as well. 
		//This tells us we don't have to try out all integers from 2 to n. Now we can modify our algorithm
		//        for (int i = 2; 2*i < n; i++) {
		//            if (n % i == 0) {
		//                return false;
		//            }
		//        }

		return true;
	}

	/* Driver program  */
	public static void main(String[] args) {
		if(isPrime(11)) 
			System.out.println(" true") ;

		else
			System.out.println(" false");

	}

}
