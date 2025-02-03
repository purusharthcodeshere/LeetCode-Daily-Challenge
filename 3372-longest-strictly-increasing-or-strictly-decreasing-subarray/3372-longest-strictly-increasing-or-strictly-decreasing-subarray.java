class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int N = nums.length;
        int maxLength = 0;

        //Find the longest strictly increasing subarray
        for (int i = 0; i < N; i++) {
            int currentLength = 1;
            for (int j = i + 1; j < N; j++) {
                if (nums[j] > nums[j - 1]) {
                    currentLength++;
                } else {
                    break;
                }
            }

            maxLength = Math.max(maxLength, currentLength);
        }

        //Find the longest strictly decreasing subarray
        for (int i = 0; i < N; i++) {
            int currentLength = 1;
            for (int j = i + 1; j < N; j++) {
                if (nums[j] < nums[j - 1]) {
                    currentLength++;
                } else {
                    break;
                }
            }

            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}