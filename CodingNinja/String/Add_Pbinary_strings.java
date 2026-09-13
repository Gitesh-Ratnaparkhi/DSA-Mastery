// Add binary strings
// Link -> https://www.naukri.com/code360/problem-of-the-day/easy?leftPanelTabValue=PROBLEM
// Level -> Easy
// Topic -> String
// Code ->
public class Add_Pbinary_strings 
{
	public static String addBinaryString(String a, String b, int n, int m)
	{
		// Write your code here.
		int i=n-1;
		int j=m-1;
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		while(i>=0 || j>=0 || carry > 0){
			int sum = carry;
			if(i >= 0){
				sum += a.charAt(i) -'0';
				i--;
			}
			if(j >= 0){
				sum += b.charAt(j) -'0';
				j--;
			}
			sb.append(sum % 2);
			carry = sum /  2;
		}
		return sb.reverse().toString();
	}
}

// Time Complexity: O(max(n, m)) where n and m are the lengths of the input binary strings a and b respectively. This is because we are iterating through both strings from the end to the beginning, and the maximum number of iterations will be equal to the length of the longer string.
// Space Complexity: O(max(n, m)) for the StringBuilder used to store the result. In the worst case, the result can be one digit longer than the longer of the two input strings (if there is a carry at the end).