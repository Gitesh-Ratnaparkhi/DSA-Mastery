// Nearest Smaller Element
// Link -> https://www.interviewbit.com/problems/nearest-smaller-element/
// Level -> Easy
// Approach -> Stack
// Code ->

import java.util.ArrayList;
import java.util.Stack;

public class Nearest_Smaller_Element {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < A.size(); i++) {
            int current = A.get(i);

            while (!stack.isEmpty() && stack.peek() >= current) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ans.add(-1);
            } else {
                ans.add(stack.peek());
            }

            stack.push(current);
        }

        return ans;
    }
}

// Time Complexity: O(n) - Each element is pushed and popped from the stack at most once.
// Space Complexity: O(n) - The stack stores at most n elements.