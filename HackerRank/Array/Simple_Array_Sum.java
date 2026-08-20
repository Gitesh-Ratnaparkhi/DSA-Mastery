// Simple Array Sum

// Link -> https://www.hackerrank.com/challenges/simple-array-sum/problem

// Code ->
class Result {

    public static int simpleArraySum(List<Integer> ar) {
    // Write your code here
        int sum = 0;
        for(int i : ar) sum+=i;
        return sum;
    }

}

// Time Complexity -> O(n)
// Space Complexity -> O(1)