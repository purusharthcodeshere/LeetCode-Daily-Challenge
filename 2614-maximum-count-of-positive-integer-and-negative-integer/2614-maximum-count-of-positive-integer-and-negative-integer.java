class Solution {
    public int maximumCount(int[] nums) {
        int N = nums.length;
        int neg = count(nums, 0);
        int pos = N - count(nums, 1);
        return Math.max(neg, pos);
    }

    private int count(int[] nums, int target) {
        int left = 0, right = nums.length - 1, result = nums.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                result = mid; 
                right = mid - 1;
            }
        }

        return result;
    }
}