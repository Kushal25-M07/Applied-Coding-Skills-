import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Map to store the value and its most recent index
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            
            // Check if we have seen this number before and if the index difference is <= k
            if (map.containsKey(currentNum) && i - map.get(currentNum) <= k) {
                return true;
            }
            
            // Add or update the number's most recent index in the map
            map.put(currentNum, i);
        }
        
        return false;
    }
}
