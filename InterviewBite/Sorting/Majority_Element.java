// Majority Element
// Link -> https://www.interviewbit.com/problems/majority-element/?study_plan=study-plan-3-months&/
// Level -> Easy
// Topic -> Array + Sorting
// Code ->


public class Majority_Element {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int majorityElement(final int[] A) {
        Arrays.sort(A);
        return A[A.length / 2];
    }
}

// Time Complexity: O(nlogn) -> Sorting the array
// Space Complexity: O(1)