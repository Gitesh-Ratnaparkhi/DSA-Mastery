// 1711. Count Good Meals

// Link -> https://leetcode.com/problems/count-good-meals/description/

// Approach -> Brute Force
// 1. Iterate through the input array and for each element, check if it is a good meal.
// 2. If it is a good meal, increment the count.
// 3. Return the count.

// Code ->
class Solution {
    public int countPairs(int[] deliciousness) {
        int n = deliciousness.length;
        int ans = 0;
        for(int i=0; i<n ; i++){
            for(int j=i+1; j<n ; j++){
                int sum = deliciousness[i] + deliciousness[j];
                if (sum > 0 && (sum & (sum - 1)) == 0) ans++;
                ans %= 100000007;
            }
        }
        return ans;
    }
}

// Time Complexity -> O(n^2)
// Space Complexity -> O(1)


// Approach 2 : Hash Map


// Code ->
class Solution {
    public int countPairs(int[] deliciousness) {
        int n = deliciousness.length;
        int MOD = 1000000007;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i : deliciousness) mp.put(i, mp.getOrDefault(i, 0) + 1); 

        long ans = 0;
        for (int i : mp.keySet()) {
            for (int j = 0; j <= 21; j++) {
                int pow = (int) Math.pow(2, j);
                int val = pow - i;
                if (val < i) continue;

                if (mp.containsKey(val)) {
                    if (val == i) {
                        long freq = mp.get(i);
                        ans += freq * (freq - 1) / 2;
                    } else ans += (long) mp.get(i) * mp.get(val);
                }
                ans %= MOD;
            }
        }
        return (int) ans;
    }
}


// Time Complexity -> O(n)
// Space Complexity -> O(n)