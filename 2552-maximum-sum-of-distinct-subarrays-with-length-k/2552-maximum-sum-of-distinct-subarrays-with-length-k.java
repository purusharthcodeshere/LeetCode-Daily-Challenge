class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int N = nums.length;
        Set<Integer> set = new HashSet<>();
        long currentSum = 0L;
        long maxSum = 0;
        int start = 0;

        for (int end = 0; end < N; end++) {
            if (!set.contains(nums[end])) {
                currentSum += nums[end];
                set.add(nums[end]);

                if (end - start + 1 == k) {
                    maxSum = Math.max(maxSum, currentSum);
                    currentSum -= nums[start];
                    set.remove(nums[start]);
                    start++;
                }
            } else {
                while (nums[start] != nums[end]) {
                    currentSum -= nums[start];
                    set.remove(nums[start]);
                    start++;
                }
                start++;
            }
        }

        return maxSum;
    }
}