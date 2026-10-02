// Sort Elements by Decreasing Frequency
// Link -> https://www.geeksforgeeks.org/problems/sorting-elements-of-an-array-by-frequency-1587115621/1
// Level -> Medium
// Approach -> HashMap + Sorting
// Code ->
class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // add your code here
        Map<Integer, Integer> mp = new LinkedHashMap<>();
        for (int i : arr)
            mp.put(i, mp.getOrDefault(i, 0) + 1);

        List<Map.Entry<Integer, Integer>> li = new ArrayList<>(mp.entrySet());

        li.sort((a, b) -> {
            if (!Minimum_Insertions_to_Make_Parentheses_Valid.getValue().equals(b.getValue())) {
                return Integer.compare(b.getValue(), Minimum_Insertions_to_Make_Parentheses_Valid.getValue());
            }
            return Integer.compare(Minimum_Insertions_to_Make_Parentheses_Valid.getKey(), b.getKey());
        });

        ArrayList<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : li) {
            int val = e.getKey();
            int freq = e.getValue();
            while (freq > 0) {
                ans.add(val);
                freq--;
            }
        }
        return ans;
    }
}
// Time Complexity -> O(n log n) - The sorting step dominates the time complexity, where n is the number of unique elements in the input array.
// Space Complexity -> O(n) - We use an additional array to store the frequency of each element, where n is the number of unique elements in the input array.