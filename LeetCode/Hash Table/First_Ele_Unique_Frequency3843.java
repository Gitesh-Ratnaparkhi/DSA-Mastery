// 3843. First Element with Unique Frequency


// Link -> https://leetcode.com/problems/first-element-with-unique-frequency/description/

// Code ->
class Solution {
    public int firstUniqueFreq(int[] nums) {
        HashMap<Integer ,Integer> mp = new HashMap<>();
        for(int i : nums) mp.put(i, mp.getOrDefault(i, 0) + 1);
        
        HashMap<Integer, Integer> fmp = new HashMap<>();
        for (int freq : mp.values()) fmp.put(freq, fmp.getOrDefault(freq, 0) + 1);

        for(int n : nums){
            int temp = fmp.get(mp.get(n));
            if(temp == 1) return n;
        }
        return -1;
    }
}