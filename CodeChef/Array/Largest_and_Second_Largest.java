// Largest and Second Largest
// Link -> https://www.codechef.com/practice/course/arrays/ARRAYS/problems/LARGESECOND
// Code ->


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            // Your code goes here
            
            int max = 0 , min = 0;
            for(int i=0; i<n; i++){
                if(a[i] > max){
                    min = max;
                    max = a[i];
                }
                if(a[i] > min && a[i] != max) min = a[i];
            }
            System.out.println(n == 1 ? "" : min + max);
        }
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)