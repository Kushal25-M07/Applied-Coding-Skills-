class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Frequency map for tasks A through Z
        int[] freq = new int[26];
        int maxFreq = 0;

        for (char task : tasks) {
            freq[task - 'A']++;
            maxFreq = Math.max(maxFreq, freq[task - 'A']);
        }

        // Count how many tasks have the maximum frequency
        int maxFreqCount = 0;
        for (int count : freq) {
            if (count == maxFreq) {
                maxFreqCount++;
            }
        }

        // Formula for total intervals needed
        int minimumIntervals = (maxFreq - 1) * (n + 1) + maxFreqCount;

        // If tasks array is larger than calculated slots, no idling is required
        return Math.max(tasks.length, minimumIntervals);
    }
}
