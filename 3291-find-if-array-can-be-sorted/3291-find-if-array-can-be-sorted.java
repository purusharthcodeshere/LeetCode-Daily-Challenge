class Solution {
    public boolean canSortArray(int[] nums) {
        int previousMax = Integer.MIN_VALUE;
        int currentMax = nums[0];
        int currentMin = nums[0];
        int setBits = Integer.bitCount(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (setBits == Integer.bitCount(nums[i])) {
                currentMax = Math.max(currentMax, nums[i]);
                currentMin = Math.min(currentMin, nums[i]);
            } else {
                if (currentMin < previousMax) {
                    return false;
                }
                previousMax = currentMax;
                setBits = Integer.bitCount(nums[i]);
                currentMin = nums[i];
                currentMax = nums[i];
            }
        }

        return previousMax < currentMin;
    }
}