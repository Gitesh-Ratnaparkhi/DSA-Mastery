// Reverse Words in a String
// Link -> https://www.codechef.com/practice/course/strings-intermediate/STRINGSP02/problems/REVERSEWORD
// Code ->
public static String reverseWords(String s) {
    
    String wod[] = s.trim().split("\\s+");
    StringBuilder ans = new StringBuilder();
    
    int n = wod.length;
    for(int i=n-1; i>=0; i--){
        ans.append(wod[i]);
        if(i > 0) ans.append(" ");
    }
    return ans.toString();
}
// Time Complexity: O(n)
// Space Complexity: O(n)