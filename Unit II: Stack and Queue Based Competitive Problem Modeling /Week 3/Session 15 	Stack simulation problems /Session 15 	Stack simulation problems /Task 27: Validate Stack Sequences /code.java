import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0; // Pointer for popped array

        for (int val : pushed) {
            stack.push(val); // Push the current element onto the stack

            // Pop as long as the top element matches the current popped target
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }

        // If all elements were correctly matched and popped, stack should be empty
        return stack.isEmpty();
    }
}
