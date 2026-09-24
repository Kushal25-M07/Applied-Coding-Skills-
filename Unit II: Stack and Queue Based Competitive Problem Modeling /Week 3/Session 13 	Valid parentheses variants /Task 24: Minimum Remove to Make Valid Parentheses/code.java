import java.util.*;

class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> indexesToRemove = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();

        // First pass: identify indices of invalid parentheses
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    indexesToRemove.add(i); // Unmatched ')'
                } else {
                    stack.pop(); // Matched '('
                }
            }
        }

        // Add remaining unmatched '(' indices to the remove set
        while (!stack.isEmpty()) {
            indexesToRemove.add(stack.pop());
        }

        // Second pass: build the valid string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexesToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
