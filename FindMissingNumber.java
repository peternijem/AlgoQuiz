
/*
You are given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in list. 
One of the integers is missing in the list. Write an efficient code to find the missing integer.

Algorithm:

1. Get the sum of numbers 
       total = n*(n+1)/2
2  Subtract all the numbers from sum and
   you will get the missing number.
**/


// Java program to find missing Number
 
class FindMissingNumber {
    // Function to ind missing number
    static int getMissingNo (int a[], int n) {
        int i, total;
        total  = (n+1)*(n+2)/2;   
        for ( i = 0; i< n; i++)
           total -= a[i];
        return total;
    }
      
    /* program to test above function */
    public static void main(String args[]) {
        int a[] = {1,2,4,5,6};
        int miss = getMissingNo(a,5);
        System.out.println(miss);   
    }
}
