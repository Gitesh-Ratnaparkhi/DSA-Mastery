// Majority element
// Link -> https://www.naukri.com/code360/problems/majority-element_842495?leftPanelTabValue=PROBLEM
// Level -> Easy
// Topic -> HashMap
// Code ->
import java.io.*;
import java.util.* ;

public class Solution {
	public static int findMajority(int[] arr, int n) {
		// Write your code here.
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i : arr) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> mpe : mp.entrySet()) {
            if (mpe.getValue() > n / 2) {
                return mpe.getKey();
            }
        }

        return -1;
	}
}

// Time Complexity: O(n) -> Traversing the array
// Space Complexity: O(n) -> HashMap