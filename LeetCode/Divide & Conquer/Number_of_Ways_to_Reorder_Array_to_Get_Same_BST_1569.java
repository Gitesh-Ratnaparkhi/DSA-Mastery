// 1569. Number of Ways to Reorder Array to Get Same BST

// Link -> https://leetcode.com/problems/number-of-ways-to-reorder-array-to-get-same-bst/description/?envType=daily-question&envId=2026-08-18

// Difficulty -> Hard
// Approach -> Divide & Conquer + Math
// Code ->
class Solution {

    int mod = 1000000007;

    private long solve(List<Integer> li, List<List<Long>> arr) {
        int n = li.size();
        if (n <= 2) return 1;

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int val = li.get(0);

        for (int i = 1; i < n; i++) {
            if (li.get(i) < val) left.add(li.get(i));
            else right.add(li.get(i));
        }

        long x = solve(left, arr);
        long y = solve(right, arr);
        long z = arr.get(n - 1).get(left.size());

        return (((x * y) % mod) * z) % mod;
    }

    public int numOfWays(int[] nums) {
        int n = nums.length;

        if (n <= 2) return 0;

        List<Integer> li = new ArrayList<>();
        for (int num : nums) {
            li.add(num);
        }

        List<List<Long>> arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            List<Long> row = new ArrayList<>(Collections.nCopies(i + 1, 1L));
            for (int j = 1; j < i; j++) {
                long val = (arr.get(i - 1).get(j - 1) + arr.get(i - 1).get(j)) % mod;
                row.set(j, val);
            }
            arr.add(row);
        }

        long ans = solve(li, arr);
        return (int) ((ans - 1 + mod) % mod);
    }
}

// Time Complexity -> O(n^2)
// Space Complexity -> O(n^2)
