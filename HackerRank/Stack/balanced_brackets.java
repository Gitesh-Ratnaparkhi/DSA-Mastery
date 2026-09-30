// balanced-brackets
// Link -> https://www.hackerrank.com/challenges/balanced-brackets/problem?isFullScreen=true
// Level -> Medium
// Approach -> Stack
// Code ->

import java.io.*;
import java.util.Stack;
import java.util.stream.IntStream;
class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        if(s.charAt(0) == ')' || s.charAt(0) == '}' || s.charAt(0) == ']')
            return "NO";
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '{' || ch == '(' || ch == '[') st.push(ch);
            else{
                if (st.isEmpty()) return "NO";
                if(ch == ')' && st.peek() != '(')return "NO";
                else if(ch == ']' && st.peek() != '[')return "NO";
                else if(ch == '}' && st.peek() != '{') return "NO";
                else st.pop(); 
            }
        }
        
        return st.isEmpty() ? "YES" : "NO";
    }

}

public class balanced_brackets {
// public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}


// Time Complexity -> O(n)
// Space Complexity -> O(n)