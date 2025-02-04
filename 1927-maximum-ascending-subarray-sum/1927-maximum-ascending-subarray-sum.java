class Solution {
    public int maxAscendingSum(int[] nums) {
        int N = nums.length;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            int currentSum = nums[i];
            for (int j = i + 1; j < N; j++) {
                if (nums[j - 1] < nums[j]) {
                    currentSum += nums[j];
                } else {
                    break;
                }
            }

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}