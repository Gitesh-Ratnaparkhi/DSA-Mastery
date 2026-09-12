// First non repeating character
// Link -> https://www.naukri.com/code360/problems/first-non-repeating-character_920324?leftPanelTabValue=PROBLEM
// Level -> Easy
// Topic -> String
// Code ->
public class First_non_repeating_character {

	public static char firstNonRepeatingCharacter(String str) {

		// Write your code here
        int fr[] = new int[52];

        for (char ch : str.toCharArray()) {
            if (ch >= 'a' && ch <= 'z')
                fr[ch - 'a']++;
            else if (ch >= 'A' && ch <= 'Z')
                fr[26 + (ch - 'A')]++;
        }

        char ans =str.charAt(0);

        for (int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z' && fr[ch - 'a'] == 1) {
                ans = ch;
                break;
            }
            else if (ch >= 'A' && ch <= 'Z' && fr[26 + (ch - 'A')] == 1) {
                ans = ch;
                break;
            }
        }

        return ans;
	}
}


// Time Complexity: O(n) where n is the length of the string
// Space Complexity: O(1) since the frequency array size is constant (52)