// 1093. Statistics from a Large Sample

// Link: https://leetcode.com/problems/statistics-from-a-large-sample/description/?envType=daily-question&envId=2026-07-26

// Approach -> Math

// Code ->
class Solution {

    private double helper(Map<Integer, Integer> mp, int size) {

        int left = (size - 1) / 2;
        int right = size / 2;
        int first = -1;
        int second = -1;
        int curr = 0;

        for (Map.Entry<Integer, Integer> e : mp.entrySet()) {

            int key = e.getKey();
            int freq = e.getValue();

            if (first == -1 && left < curr + freq)
                first = key;
            if (right < curr + freq) {
                second = key;
                break;
            }

            curr += freq;
        }
        if (size % 2 != 0)
            return second;
        return (first + second) / 2.0;
    }

    public double[] sampleStats(int[] count) {

        int n = count.length;

        double min = 257;
        double max = 0;
        double mean = 0;
        double median = 0;
        double mode = 0;

        int freq = 0;
        int size = 0;

        Map<Integer, Integer> mp = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            if (count[i] != 0) {
                if (min == 257)
                    min = i;

                max = Math.max(max, i);
                mean += (double) i * count[i];
                if (count[i] > freq) {
                    freq = count[i];
                    mode = i;
                }
                mp.put(i, count[i]);
                size += count[i];
            }
        }
        median = helper(mp, size);
        double[] ans = {
                min,
                max,
                mean / size,
                median,
                mode
        };
        return ans;
    }
}

// Time Complexity -> O(n log n)
// Space Complexity -> O(n)

// Approach 2 ->

// Code ->
class Solution {
    public double[] sampleStats(int[] count) {
        int n = count.length;

        double min = -1.0;
        double max = -1.0;
        double sum = 0.0;
        double mode = 0.0;
        int maxFreq = 0;
        int totalCount = 0;

        // First pass: Calculate min, max, mean sum, mode, and total count
        for (int i = 0; i < n; i++) {
            if (count[i] > 0) {
                if (min == -1.0)
                    min = i;
                max = i;
                sum += (double) i * count[i];
                if (count[i] > maxFreq) {
                    maxFreq = count[i];
                    mode = i;
                }
                totalCount += count[i];
            }
        }

        // Second pass: Find median using the known total count
        int leftIdx = (totalCount + 1) / 2;
        int rightIdx = (totalCount + 2) / 2;
        int firstMedian = -1;
        int secondMedian = -1;
        int curr = 0;

        for (int i = 0; i < n; i++) {
            if (count[i] > 0) {
                curr += count[i];
                if (firstMedian == -1 && curr >= leftIdx) {
                    firstMedian = i;
                }
                if (curr >= rightIdx) {
                    secondMedian = i;
                    break;
                }
            }
        }

        double median = (firstMedian + secondMedian) / 2.0;

        return new double[] { min, max, sum / totalCount, median, mode };
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(1)