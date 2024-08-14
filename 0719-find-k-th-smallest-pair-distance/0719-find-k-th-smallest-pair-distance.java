class Solution {
    int[] nums;
    int k;

    public int smallestDistancePair(int[] nums, int k) {
        this.nums = nums;
        this.k = k;

        Arrays.sort(nums);

        int left = 0;
        int right = nums[nums.length - 1] - nums[0];

        while (left < right) {
            int mid = left + ((right - left) / 2);

            if (checkPairs(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean checkPairs(int mid) {
        int count = 0, left = 0;
        for (int right = 1; right < nums.length; right++) {
            while (nums[right] - nums[left] > mid) {
                left++;
            }

            count += right - left;
        }

        return (count >= k);
    }
}