
/* Java program for Merge Sort */
public class MergeSort { 
	
    //Merges two subarrays of arr[]; First subarray is arr[l..m]. Second subarray is arr[m+1..r]
    private void merge(int arr[], int l, int m, int r) { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; //size of array arr[1...m]
        int n2 = r - m; 
  
        /* Create temp arrays */
        int leftArr[] = new int [n1]; 
        int rightArr[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i < n1; ++i) {
            leftArr[i] = arr[l + i]; 
        }
        for (int j=0; j < n2; ++j) { 
            rightArr[j] = arr[m + 1+ j]; 
        }
  
        int i = 0, j = 0; 
  
        //Merge the subbarray
        int k = l; 
        while (i < n1 && j < n2)  { 
            if (leftArr[i] <= rightArr[j]) { 
                arr[k] = leftArr[i]; 
                i++; 
            } else { 
                arr[k] = rightArr[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of leftArr[] if any */
        while (i < n1) 
        { 
            arr[k] = leftArr[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of rightArr[] if any */
        while (j < n2)  { 
            arr[k] = rightArr[j]; 
            j++; 
            k++; 
        } 
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    void sort(int arr[], int l, int r) { 
        if (l < r) { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            sort(arr, l, m); 
            sort(arr , m+1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    } 
  
    /* A utility function to print array of size n */
    static void printArray(int arr[]) { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(); 
    } 
  
    // Driver method 
    public static void main(String args[]) { 
        int arr[] = {12, 11, 13, 5, 6, 7}; 
  
        System.out.println("Given Array"); 
        printArray(arr); 
  
        MergeSort ob = new MergeSort(); 
        ob.sort(arr, 0, arr.length-1); 
  
        System.out.println("\nSorted array"); 
        printArray(arr); 
    } 
} 
