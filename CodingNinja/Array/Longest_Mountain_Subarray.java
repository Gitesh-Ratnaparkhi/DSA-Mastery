// Longest Mountain Subarray 
// Link -> 
// Level -> Easy
// Approach -> Two Pointers
// Code ->
public class Longest_Mountain_Subarray {
	
	public static int longestMountain(int arr[], int n)
	{
		// Write your code here.
		int ans = 0;
		int i =1;
		while(i < n-1){
			if(arr[i-1] < arr[i] && arr[i] > arr[i+1]){
				int left = i-1;
				while(left > 0 && arr[left-1] < arr[left]){
					left--;
				}
				int right = i+1;
				while(right < n-1 && arr[right] > arr[right+1]){
					right++;
				}
				ans = Math.max(ans, right - left + 1);
				i = right;
			}else i++;
			
		}
		return ans;
	}
}

// Time Complexity -> O(n)
// Space Complexity -> O(1)