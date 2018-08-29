
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


//Java program to find the interval which has the maximum number of overlapping intervals
// Input: { (0,2), (3, 7), (4,6), (7,8), (1,5) }. Output: Interval (4,5) has the maximum number of overlapping intervals which is 3.
public class MaxOverlapIntervalCount {

	private static final String MAX_OVERLAP_INTERVAL = "MAX_OVERLAP_INTERVAL";
	private static final String START_POINT = "START_POINT";
	private static final String END_POINT = "END_POINT";

	public static void main(String[] args) throws IllegalArgumentException {
		int [] s = {0, 1, 3, 4, 7};
		int [] e = {2, 5, 6, 7, 8};
		Map<String, Integer> resMap = maxOverlapIntervalCount(s, e);
		System.out.println("Max Overlapping Interval: " +resMap.get(MAX_OVERLAP_INTERVAL)+
				". Occuring at point: (" + resMap.get(START_POINT)+","+resMap.get(END_POINT)+")");
		
		int [] s2 = {0, 3, 4, 7, 1};
		int [] e2 = {2, 7, 6, 8, 5};
		resMap = maxOverlapIntervalCount_2(s2, e2);
		System.out.println("Max Overlapping Interval: " +resMap.get(MAX_OVERLAP_INTERVAL)+
				". Occuring at point: (" + resMap.get(START_POINT)+","+resMap.get(END_POINT)+")");
	}
	
	public static Map<String, Integer> maxOverlapIntervalCount(int[] start, int[] end) throws IllegalArgumentException{
		
		if(start.length != end.length) {
			throw new IllegalArgumentException();
		}
		int maxOverlap = 0;
		int currentOverlap = 0;
		
		Arrays.sort(start);
		Arrays.sort(end);
		
		int i = 0;int startPoint = 0;
		int j = 0;int endPoint = 0;
		int m = start.length,n = end.length;
		
		while(i < m && j < n){
			if(start[i] < end[j]){
				currentOverlap++;
				if(currentOverlap > maxOverlap) {
					maxOverlap = currentOverlap;
					startPoint = start[i];
					endPoint = end[j];
				}		
				i++;
			}
			else{
				currentOverlap--;
				j++;
			}
		}
		
		return buildResult(maxOverlap, startPoint, endPoint);
	}
	
	public static Map<String, Integer> maxOverlapIntervalCount_2(int[] start, int[] end) throws IllegalArgumentException{
		
		if(start.length != end.length) {
			throw new IllegalArgumentException();
		}
	
		int[] tmpEnd = Arrays.copyOf(end, end.length);
		Arrays.sort(tmpEnd); 
		//the size of the int array would be the max end point + 1
		int size = tmpEnd[tmpEnd.length - 1] + 1;
		int[] intArr = new int[size];
		
		int maxOverlap = 0;
		int startPoint = 0; int endPoint = 0;
		
		
		for(int i=0;i < start.length; i++) {
			int currStart = start[i];
			int currEnd = end[i];
			for(int j = currStart; j<=currEnd; j++) {
				intArr[j] += 1;
				if(intArr[j] > maxOverlap) {
					startPoint = j;
					endPoint = currEnd;
					maxOverlap = intArr[j]; 
				}
			}
		}
		
		
		return buildResult(maxOverlap, startPoint, endPoint);
		
	}

	private static Map<String, Integer> buildResult(int maxOverlap, int startPoint, int endPoint) {
		Map<String, Integer> resMap = new HashMap<>();
		resMap.put(START_POINT, startPoint);
		resMap.put(END_POINT, endPoint);
		resMap.put(MAX_OVERLAP_INTERVAL, maxOverlap);
		return resMap;
	}

}
