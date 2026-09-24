import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = prices.clone();
        Deque<Integer> stack = new ArrayDeque<>(); // Stores indices

        for (int i = 0; i < n; i++) {
            // Apply discount for all previous items larger than or equal to current price
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int prevIndex = stack.pop();
                result[prevIndex] -= prices[i];
            }
            stack.push(i);
        }

        return result;
    }
}
