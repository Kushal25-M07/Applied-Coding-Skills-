class Solution {
    public void moveZeroes(int[] nums) {
        // Pointer to place the next non-zero element
        int lastNonZeroFoundAt = 0;

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If the current element is non-zero
            if (nums[i] != 0) {
                // Swap current element with the element at lastNonZeroFoundAt
                int temp = nums[i];
                nums[i] = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt] = temp;
                
                // Move the pointer forward
                lastNonZeroFoundAt++;
            }
        }
    }
}
