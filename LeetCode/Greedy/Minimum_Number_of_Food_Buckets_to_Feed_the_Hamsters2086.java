// 2086. Minimum Number of Food Buckets to Feed the Hamsters
// Link -> https://leetcode.com/problems/minimum-number-of-food-buckets-to-feed-the-hamsters/
// Approach -> Greedy [Medium]
// Code ->
class Solution {
    public int minimumBuckets(String hamsters) {
        int n = hamsters.length();
        int buckets = 0;
        int i = 0;

        while (i < n) {
            if (hamsters.charAt(i) == 'H') {
                if (i + 1 < n && hamsters.charAt(i + 1) == '.') {
                    buckets++;
                    i += 3;
                } else if (i - 1 >= 0 && hamsters.charAt(i - 1) == '.') {
                    buckets++;
                    i++;
                } else {
                    return -1;
                }
            } else {
                i++;
            }
        }

        return buckets;
    }
}
// Time Complexity: O(n) -> We are traversing the string once, where n is the length of the string.
// Space Complexity: O(1) -> We are using a constant amount of extra space for the buckets variable.