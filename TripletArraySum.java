import java.util.Arrays;

//Java program to check if given array 
//has 3 elements whose sum is equal 
//to the given value
public class TripletArraySum {

	// Function to check if array has 3 elements 
	// whose sum is equal to the given value
	static boolean hasArrayThreeCandidates(int A[], int arr_size, int sum) {

		/* Sort the elements */
		Arrays.sort(A);

		/* Now look for the three candidates 
		     in the sorted array*/
		int l = 0;
		int r = arr_size-1;
		for (int i = 0; i < arr_size - 2; i++) {
			r = arr_size-1;
			l = i+1;
			while (l < r) {
				if( A[i] + A[l] + A[r] == sum) {
					System.out.println("Array has Three elements with given sum");
					System.out.println(String.format("The elements are: %s, %s and %s" , A[i], A[l], A[r]));
					return true; 
				} else if( A[i] + A[l] + A[r] < sum) {
					l++;
				} else {
					r--;
				}
			} 
			
		}
		return false;
	}

	// Driver code
	public static void main(String args[]) {
		int A[] = {1, 4, 45, 6, 10, -8};
		int n = 20;
		int arr_size = A.length;

		// Function calling
		if(!hasArrayThreeCandidates(A, arr_size, n)) {
			System.out.println("Array doesn't have " +
					"Three elements with given sum");
		} 
	}

}
