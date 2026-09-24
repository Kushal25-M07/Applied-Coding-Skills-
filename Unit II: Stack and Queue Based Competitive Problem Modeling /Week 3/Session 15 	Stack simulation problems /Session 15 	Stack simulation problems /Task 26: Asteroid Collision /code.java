import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean exploded = false;

            // Collision only happens when top of stack moves RIGHT (>0) 
            // and the current asteroid moves LEFT (<0)
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                if (stack.peek() < -asteroid) {
                    // Top asteroid is smaller; destroy it and check next
                    stack.pop();
                    continue;
                } else if (stack.peek() == -asteroid) {
                    // Both asteroids are equal size; destroy both
                    stack.pop();
                    exploded = true;
                    break;
                } else {
                    // Top asteroid is larger; current asteroid explodes
                    exploded = true;
                    break;
                }
            }

            // If the current asteroid survived all collisions, add it to the stack
            if (!exploded) {
                stack.push(asteroid);
            }
        }

        // Convert stack to result array
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
