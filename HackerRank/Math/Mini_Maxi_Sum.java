// Mini Maxi Sum

// Link -> https://www.hackerrank.com/challenges/mini-max-sum/problem

// Code ->
class Result {

    public static void miniMaxSum(List<Integer> arr) {
    // Write your code here
        Collections.sort(arr);
        int n = arr.size();
        long min =(long) arr.get(0) + arr.get(1) + arr.get(2) + arr.get(3);
        long max =(long) arr.get(n-1) + arr.get(n-2) + arr.get(n-3) + arr.get(n-4);
        System.out.print(min);
        System.out.print(" ");
        System.out.print(max);
    }

}

// Time Complexity -> O(n log n)
// Space Complexity -> O(1)