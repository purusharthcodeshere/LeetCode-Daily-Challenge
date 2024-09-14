class Solution {
    public int longestSubarray(int[] nums) {
        int N = nums.length;
        int max = Integer.MIN_VALUE, count = 0, maxCount = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, nums[i]);
        }

        for (int i = 0; i < N; i++) {
            if (max == nums[i]) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }

        maxCount = Math.max(maxCount, count);
        if (maxCount == 0) {
            return 1;
        }

        return maxCount;
    }
}