import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        // Add the current request timestamp
        queue.add(t);
        
        // Remove timestamps older than (t - 3000)
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }
        
        // The remaining elements in the queue fall within [t - 3000, t]
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
