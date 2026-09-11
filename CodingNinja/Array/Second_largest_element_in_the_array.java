// Second largest element in the array
// Link -> https://www.naukri.com/code360/problems/second-largest-element-in-the-array_873375?leftPanelTabValue=PROBLEM

// Code ->

public class Solution {
	public static int findSecondLargest(int n, int[] arr) {
		// Write your code here.
		int max = Integer.MIN_VALUE , min = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(arr[i] > max){
                min = max;
                max = arr[i];
            }
            if(arr[i] > min && arr[i] != max) min = arr[i];
        }
		return min == Integer.MIN_VALUE ? -1 : min;
	}
}

// Time Complexity -> O(n)
// Space Complexity -> O(1)