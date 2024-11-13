class Solution {
    int N;
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        this.N = nums.length;
        return getPairs(nums, upper + 1) - getPairs(nums, lower);
    }

    public long getPairs(int[] nums, int val) {
        int left = 0, right = N - 1;
        long result = 0;

        while (left <= right) {
            if (nums[left] + nums[right] < val) {
                result += right - left;
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}