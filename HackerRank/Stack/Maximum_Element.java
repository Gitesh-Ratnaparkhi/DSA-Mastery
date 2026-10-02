// Maximum Element
// Link: https://www.hackerrank.com/challenges/maximum-element/problem
// Level: Easy
// Topic: Stack
// Code
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getMax' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY operations as parameter.
     */

    public static List<Integer> getMax(List<String> operations) {
    // Write your code here
        Stack<Integer> st = new Stack<>();
        Stack<Integer> max = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<operations.size(); i++){
            String tokens[] = operations.get(i).trim().split("\\s+");
            int t = Integer.parseInt(tokens[0]);
            if(t == 1){
                int num = Integer.parseInt(tokens[1]);
                st.push(num);
                if(!max.isEmpty()) max.push(Math.max(max.peek(), num));
                else max.push(num);
            }else if(t == 2){
                st.pop();
                max.pop();
            }else ans.add(max.peek());
        }
        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ops = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> res = Result.getMax(ops);

        bufferedWriter.write(
            res.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

// Time Complexity: O(n) where n is the number of operations. Each operation is processed in constant time.
// Space Complexity: O(n) where n is the number of operations. The maximum size of the stack is equal to the number of operations.