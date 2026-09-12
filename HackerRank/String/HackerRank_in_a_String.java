// HackerRank in a String
// Link -> https://www.hackerrank.com/challenges/hackerrank-in-a-string/problem
// Level -> Easy
// Topic -> String
// Code ->


class Result {

    /*
     * Complete the 'hackerrankInString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String hackerrankInString(String s) {
    // Write your code here
        String check = "hackerrank";
        int i = 0;
        for (int j = 0; j < s.length() && i < check.length(); j++) {
            if(s.charAt(j) == check.charAt(i)) i++;
        }
        return i == check.length() ? "YES" : "NO";
    }

}

public class HackerRank_in_a_String {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.hackerrankInString(s);

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

// Time Complexity: O(n) where n is the length of the string
// Space Complexity: O(1) since we are using a constant amount of extra space