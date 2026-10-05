// Boy or Girl
// Link -> https://codeforces.com/problemset/problem/236/A
// Level -> Easy;
// Approach -> HashSet;
// Code -> 

package Codeforce.HashTable;

import java.util.HashSet;
import java.util.Scanner;

public class ABoyOrGirl236A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        HashSet<Character> set = new HashSet<>();
        for(int i=0; i<s.length(); i++){
            set.add( s.charAt(i));
        }
        if(set.size() % 2 == 0) System.out.println("CHAT WITH HER!");
        else System.out.println("IGNORE HIM!");
    }
}

// Time Complexity: O(n) where n is the length of the string
// Space Complexity: O(n)


// Approach 2 -> Array 
// Code ->
public class ABoyOrGirl236A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int arr[] = new int[26];
        for(int i=0; i<s.length(); i++){
            arr[s.charAt(i) - 'a']++;
        }
        int count = 0;
        for(int i=0; i<26; i++){
            if(arr[i] > 0) count++;
        }
        if(count % 2 == 0) System.out.println("CHAT WITH HER!");
        else System.out.println("IGNORE HIM!");
    }
}

// Time Complexity: O(n) where n is the length of the string
// Space Complexity: O(1)