// Sort Elements By Frequency
// Link -> https://www.naukri.com/code360/problems/sort-elements-by-frequency_1280138?leftPanelTabValue=PROBLEM
// Level -> Easy
// Topic -> HashMap
// Code ->

public class Solution {
    public static int[] sortByFrequency(int[] nums) {
        Map<Integer, Integer> mp = new LinkedHashMap<>();
        for (int i : nums) mp.put(i, mp.getOrDefault(i, 0) + 1);

        List<Map.Entry<Integer, Integer>> li = new ArrayList<>(mp.entrySet());
        
        li.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        int idx = 0;
        for (Map.Entry<Integer, Integer> e : li) {
            int val = e.getKey();
            int freq = e.getValue();
            while (freq > 0) {
                nums[idx++] = val;
                freq--;
            }
        }   
        return nums;
    }
}

// Time Complexity -> O(nlogn)
// Space Complexity -> O(n)