class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Calculate the total sum of all elements
        int rightSum = 0;
        for (int num : nums) {
            rightSum += num;
        }
        
        int leftSum = 0;
        
        for (int i = 0; i < n; i++) {
            // Subtract current element from rightSum to represent sum of elements after index i
            rightSum -= nums[i];
            
            // Formula derived from splitting left and right of index i:
            // Left contribution:  (nums[i] * i) - leftSum
            // Right contribution: rightSum - (nums[i] * (n - 1 - i))
            int leftContribution = nums[i] * i - leftSum;
            int rightContribution = rightSum - nums[i] * (n - 1 - i);
            
            result[i] = leftContribution + rightContribution;
            
            // Add current element to leftSum for the next iteration
            leftSum += nums[i];
        }
        
        return result;
    }
}
