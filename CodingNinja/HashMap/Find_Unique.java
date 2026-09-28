// Find Unique
// Link -> https://www.naukri.com/code360/problems/find-unique_625159?interviewProblemRedirection=true&leftPanelTabValue=PROBLEM
// Level -> Easy
// Topic -> HashMap
// Code ->

public class Find_Unique {

  public static int findUnique(int[] arr) {
    // Your code goes here
    HashMap<Integer, Integer> mp = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
    }
    int ans = 0;
    for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
      if (entry.getValue() == 1)
        ans = entry.getKey();

    }
    return ans;
  }
}

// Time Complexity -> O(n)
// Space Complexity -> O(n)
