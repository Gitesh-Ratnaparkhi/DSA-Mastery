// 307. Range Sum Query - Mutable

// Link -> https://leetcode.com/problems/range-sum-query-mutable/description/

// Approach ->
// This code will give Time Limited Excreded Error.

// Code ->
class NumArray {

    int arr[];
    int pre[];

    public NumArray(int[] nums) {
        arr = nums;
        pre = new int[nums.length];
        pre[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            pre[i] = pre[i - 1] + nums[i];
    }

    public void update(int index, int val) {
        int diff = val - arr[index];
        arr[index] = val;

        for (int i = index; i < pre.length; i++)
            pre[i] += diff;
    }

    public int sumRange(int left, int right) {
        if (left > 0)
            return pre[right] - pre[left - 1];
        return pre[right];
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(n)



// Another Approach ->


// Code ->
class NumArray {

    int[] arr;
    int[] bit;
    int n;

    public NumArray(int[] nums) {
        n = nums.length;
        arr = nums.clone();
        bit = new int[n + 1];

        for (int i = 0; i < n; i++) {
            add(i + 1, nums[i]);
        }
    }

    private void add(int index, int value) {
        while (index <= n) {
            bit[index] += value;
            index += index & -index;
        }
    }

    private int prefixSum(int index) {
        int sum = 0;

        while (index > 0) {
            sum += bit[index];
            index -= index & -index;
        }

        return sum;
    }

    public void update(int index, int val) {
        int diff = val - arr[index];
        arr[index] = val;

        add(index + 1, diff);
    }

    public int sumRange(int left, int right) {
        return prefixSum(right + 1) - prefixSum(left);
    }
}
